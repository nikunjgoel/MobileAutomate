package pageClasses;

import static org.testng.Assert.assertTrue;

import java.awt.Menu;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import helper.Constants;
import helper.GenUtility;
import helper.Log;
import helper.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends TestBase {

	public LoginPage(AndroidDriver<WebElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = Constants.password_Id)
	public WebElement password;
	@AndroidFindBy(xpath = Constants.LoginButton_Id)
	public WebElement LoginButton;
	@AndroidFindBy(xpath = Constants.skipSignIN)
	public WebElement skipsignbutton;
	@AndroidFindBy(xpath = Constants.alreadySignnIN)
	public WebElement alreadySign;
	@AndroidFindBy(xpath = Constants.continuesignbutton)
	public WebElement continuebutton;
	@AndroidFindBy(xpath = Constants.email)
	public WebElement email;
	@AndroidFindBy(xpath = Constants.inCorrectEmailAddress)
	public WebElement incorrectemail;
	@AndroidFindBy(xpath = Constants.inCorrectPhonenumber)
	public WebElement incorrectphone;
	@AndroidFindBy(xpath = Constants.inCorrectPwdAddress)
	public WebElement incorrectpwd;
	@AndroidFindBy(xpath = Constants.inCorrectemailCrossicon)
	public WebElement crossbutton;

	/**
	 * Author: nikgoel1 Login Page
	 * 
	 * @param username,
	 *            Password the command line arguments.
	 * @exception Any
	 *                exception
	 * @return null value.
	 */
	public void login(String UserName, String Password) {
		try {
			sendKeys(email, UserName);
			webDriverWaitAndClick(continuebutton);
			sendKeys(password, Password);
			webDriverWaitAndClick(LoginButton);
			test.log(LogStatus.PASS,
					"User " + UserName + " credentials on login page are entered and hit Login button successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(LogStatus.FAIL,
					"Home page is not loaded successfully with following exception: " + e.getMessage());
		}
	}

	/**
	 * @desc Validate invalid login workflow
	 * @param invalidUserName
	 * @param invalidPassword
	 * @param validemail
	 * @param invalidphone
	 * @param validPassword
	 */
	public void inValidlogin(String invalidUserName, String invalidPassword, String validemail, String invalidphone,
			String validPassword) {
		try {
			test.log(LogStatus.INFO, "Entering user credentials on login page and hitting Login button");
			sendKeys(email, invalidUserName);
			webDriverWaitAndClick(continuebutton);
			assertTrue(isElementDisplayed(incorrectemail));
			webDriverWaitAndClick(crossbutton);
			sendKeys(email, invalidphone);
			webDriverWaitAndClick(continuebutton);
			assertTrue(isElementDisplayed(incorrectphone));
			webDriverWaitAndClick(crossbutton);
			Log.info("Validate Invalid email workflow");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());

			test.log(LogStatus.FAIL, "Login error: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param invalidUserName
	 * @param invalidPassword
	 * @param validemail
	 * @param invalidphone
	 * @param validPassword
	 */
	public void verifyInValidlogin(String invalidUserName, String invalidPassword, String validemail,
			String invalidphone, String validPassword) {
		try {
			test.log(LogStatus.INFO, "Entering user credentials on login page and hitting Login button");
			sendKeys(email, validemail);
			webDriverWaitAndClick(continuebutton);
			sendKeys(password, invalidPassword);
			webDriverWaitAndClick(LoginButton);
			assertTrue(isElementDisplayed(incorrectpwd));
			Log.info("Validate invalid password flow successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Log.info(e.getMessage());

			test.log(LogStatus.FAIL, "Login error: " + e.getMessage());
		}
	}
}
