package managers;

import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import pageClasses.SearchPage;
import pageClasses.CheckoutPage;
import pageClasses.HomePage;
import pageClasses.LoginPage;

public class PageObjectManager {

	private AndroidDriver<WebElement> driver;

	private ExtentTest _test;

	private LoginPage loginPage;

	private HomePage homePage;

	private SearchPage searchPage;
	private CheckoutPage checkOutPage;

	public PageObjectManager(AndroidDriver<WebElement> driver, ExtentTest _test) {

		this.driver = driver;
		this._test = _test;
	}

	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(driver, _test) : loginPage;

	}

	public HomePage getHomePage() {

		return (homePage == null) ? homePage = new HomePage(driver, _test) : homePage;

	}

	public SearchPage getSearchPage() {

		return (searchPage == null) ? searchPage = new SearchPage(driver, _test) : searchPage;
	}

	public CheckoutPage getCheckOutPage() {
		return (checkOutPage == null) ? checkOutPage = new CheckoutPage(driver, _test) : checkOutPage;
	}

}
