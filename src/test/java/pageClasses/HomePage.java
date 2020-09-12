package pageClasses;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import helper.Config;
import helper.Constants;
import helper.GenUtility;
import helper.Log;
import helper.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;

public class HomePage extends TestBase {

	public HomePage(AndroidDriver<WebElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/**
	 * @nikgoel1
	 * @return
	 */
	@AndroidFindBy(xpath = Constants.alreadySignnIN)
	public WebElement SignInButton;

	/**
	 * validate app launch by verifying sign In button
	 */
	public void HomePageNavigation() {
		try {
			assertTrue(isElementDisplayed(SignInButton));
			scrollVisibleText("Skip sign in");
			webDriverWaitAndClick(SignInButton);
			System.out.println("Click Action performed");
			Log.info("Verify sign In button");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());
			test.log(LogStatus.FAIL,
					"Home page is not loaded successfully with following exception: " + e.getMessage());
		}
	}

}
