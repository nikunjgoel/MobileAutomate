package managers;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.SkipException;

import cucumber.TestContext;
import helper.Log;
import io.appium.java_client.android.AndroidDriver;

public class WebdriverInitializer {

	private AndroidDriver<WebElement> driver = null;
	public DesiredCapabilities caps = null;

	public AndroidDriver<WebElement> init_driver() {

		try {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/Apps/Amazon/");
			File app = new File(appDir, "Amazon_shopping.apk");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "emulator-5554");
			capabilities.setCapability("udid", "emulator-5554");
			capabilities.setCapability("platformVersion", "4.4");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);
			Log.info("App Launch");
		} catch (Throwable e) {
			throw new SkipException("issue while launching the browser" + e);
		}
		return driver;
	}

}
