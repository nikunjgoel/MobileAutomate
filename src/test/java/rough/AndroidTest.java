package rough;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidTest {
	static AndroidDriver<?> driver;

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		File classpathRoot = new File(System.getProperty("user.dir"));
		 File appDir = new File(classpathRoot, "/Apps/Amazon/");
		 File app = new File(appDir, "Amazon_shopping.apk");
		 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("device", "Android");
		capabilities.setCapability("deviceName","emulator-5554");
		capabilities.setCapability("udid","emulator-5554");
//Name of mobile web browser to automate. Should be an empty string if automating an app instead.
		capabilities.setCapability("platformVersion", "4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		 

		 /*DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
	        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
	        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
	        capabilities.setCapability("app", app.getAbsolutePath());
	        capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
			capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		
	    */    
		/* DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.7.1");
			//capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			//capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//	capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Browser");
			capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
			capabilities.setCapability("newCommandTimeout", 2000);
			  capabilities.setCapability("app", app.getAbsolutePath());
		        capabilities.setCapability("appPackage", "com.amazon.mShop.android.shopping");
				capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
			*/
		 
		 
		 
		 //capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE_NAME);
	       // capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY_NAME);
	        // Initialize driver
	      //  AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.0:4723/wd/hub"), capabilities);
	      //  driver.resetApp();

		 
		 
		//capabilities.setCapability("app-package", "APP PACKAGE"); //Replace with your app's package
		//capabilities.setCapability("app-activity", "APP PACKAGE.ANDROID ACTIVITY"); //Replace with app's Activity
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		//driver.resetApp();
		//driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);                  
		//driver.wait(25000);
		driver.findElement(By.xpath("//android.widget.Button[contains(@text,'Already a customer? Sign in')]")).click();
	
	}

}
