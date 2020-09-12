package rough;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Android {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException{
		
		File classpathRoot = new File(System.getProperty("user.dir"));
		 File appDir = new File(classpathRoot, "/Apps/Amazon/");
		 File app = new File(appDir, "Amazon_shopping.apk");
		 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("udid","emulator-5554");
//Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("platformName", "Android");
		//capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		 

		//capabilities.setCapability("app-package", "APP PACKAGE"); //Replace with your app's package
		//capabilities.setCapability("app-activity", "APP PACKAGE.ANDROID ACTIVITY"); //Replace with app's Activity
		driver =  new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);                  
		//driver.wait(25000);
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Already a customer? Sign in')]")).click();
	
		//driver.get("https//m.sephora.com");
	}
	
	@Test
	public void Cal() throws InterruptedException{
	//	driver.wait(5000);
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Already a customer? Sign in')]")).click();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}