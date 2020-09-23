package pageClasses;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.Constants;
import helper.Log;
import helper.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

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
			System.out.println("Click Action performed");
			Log.info("Verify sign In button");
			test.log(LogStatus.PASS,"APP Launch successfully");
	
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());
			test.log(LogStatus.FAIL,
					"Home page is not loaded successfully with following exception: " + e.getMessage());
			throw e;
		}
	}

}
