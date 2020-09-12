package pageClasses;

import static org.testng.Assert.assertTrue;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import helper.Constants;
import helper.Log;
import helper.TestBase;
import helper.XlsReader;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPage extends TestBase {
	ExtentTest test;
	WebDriverWait wait;
	XlsReader xlsReader;

	public CheckoutPage(AndroidDriver<WebElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); 
}

	@AndroidFindBy(xpath = Constants.checkoutbutton_xpath)
	public WebElement checkout;
	@AndroidFindBy(xpath = Constants.addtobasket_xpath)
	public WebElement addtobasket;
	@AndroidFindBy(xpath = Constants.deliveraddressxpath)
	public WebElement delieveraddres;
	@AndroidFindBy(xpath = Constants.shippingcontinuexpath)
	public WebElement shipcontinue;
	@AndroidFindBy(xpath = Constants.productdetailxpath)
	public WebElement productdetail;
	@AndroidFindBy(xpath = Constants.basketimagexpath)
	public WebElement basket;
	@AndroidFindBy(xpath = Constants.productshippingpagexpath)
	public WebElement shippingpageproductxpath;
	/**
	 * @author nikgoel1
	 * @description add item to checklist and compare with shipping page
	 * @param testData
	 */
	public void addItemToCheckout(Map<String, String> testData, String product) {
		try {	 
			webDriverWaitAndClick(addtobasket);
			webDriverWaitAndClick(basket);
			webDriverWaitAndClick(checkout);
			webDriverWaitAndClick(delieveraddres);
			shippingpageproductxpath.getAttribute("text").toString();
			Log.info("Product compare start in checkout page");
			Log.info(shippingpageproductxpath.getAttribute("text").toString());
			assertTrue(product.equalsIgnoreCase(shippingpageproductxpath.getAttribute("text").toString()));
			Log.info("Product compare successfully in checkout page");
			test.log(LogStatus.PASS, "All the LLD and IR files downloaded successfully.");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Fail to add item:" + e.getMessage());
		}
	}

}
