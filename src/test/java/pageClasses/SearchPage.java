package pageClasses;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import helper.Constants;
import helper.Log;
import helper.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SearchPage extends TestBase {

	public SearchPage(AndroidDriver<WebElement> driver, ExtentTest test) {
		super(driver, test);
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(xpath = Constants.searchtext) //
	public WebElement searchBox;
	@AndroidFindBy(xpath = Constants.clicksearchtext)
	public WebElement clicksearchBoxText;
	@AndroidFindBy(className = Constants.result_class)
	private List<WebElement> searchResult;
	@AndroidFindBy(xpath = Constants.clicksearchtextproduct)
	public WebElement productNamexpath;
	@AndroidFindBy(xpath = Constants.price)
	public WebElement Prictagxpath;
	@AndroidFindBy(xpath = Constants.allproduct_xpath)
	public List<WebElement> allproductcompxpath;
	@AndroidFindBy(className = Constants.allprice_class)
	private List<WebElement> allpriceResult;
	@AndroidFindBy(className = Constants.skipSignIN)
	public WebElement skipsignIn;
	
	String product;
	String price;
	Float high_price;
	List<WebElement> elementsTwo;

	/**
	 * @desc search product and store product name
	 * @param testData
	 * @return product name
	 */
	public String searchProduct(Map<String, String> testData) {
		try {
			sendKeys(searchBox, testData.get("Product"));
			clickElement(clicksearchBoxText);
			List<WebElement> producttype = driver.findElements(By.xpath(Constants.productNamexpath));
			producttype.size();
			System.out.println(producttype.get(0).getAttribute("text").toString());
			product = producttype.get(0).getAttribute("text").toString();
		} catch (Exception | AssertionError e) {
			test.log(LogStatus.FAIL, "Searchfailed with following exception: " + e.getMessage());
		}
		return product;

	}

	/**
	 * @desc Get Price detail of search product 
	 * @return price of search product
	 */
	public String verifyClickSearchData() {
		try {
			List<WebElement> pricetype = driver.findElements(By.xpath(Constants.priceNamepagexpath));
			pricetype.size();
			System.out.println(pricetype.get(0).getAttribute("content-desc").toString());
			price = (pricetype.get(0).getAttribute("content-desc")).toString();
			webDriverWaitAndClick(pricetype.get(0));
		} catch (Exception | AssertionError e) {
		}
		return price;

	}

	/**
	 * @desc price compare for product in the list
	 * Get highest and lowest price of the searched product
	 * @return
	 */
	public float comparePrice(Map<String, String> testData) {
		try {
			webDriverWaitAndClick(skipsignIn);
			sendKeys(searchBox, testData.get("Product"));
			clickElement(clicksearchBoxText);
			List<WebElement> product = driver.findElements(By.xpath(Constants.productNamexpath));
			List<WebElement> price = driver.findElements(By.xpath(Constants.priceNamepagexpath));
			assertTrue(product.size() > 0);
			assertTrue(price.size() > 0);
			String product_name;
			String product_price;
			float int_product_price;
			HashMap<Float, String> map_final_products = new HashMap<Float, String>();
			for (int i = 0; i < price.size(); i++) {
				product_name = product.get(i).getAttribute("text").toString();
				product_price = price.get(i).getAttribute("content-desc").toString();
				if(product_price!= null && product_name!=null ){
				String[] currencies = product_price.split(" ");
				String pr=currencies[0].replace("$", " ").toString();
				int_product_price = Float.parseFloat(pr);
				map_final_products.put(int_product_price, product_name);
				}
			}
			Log.info("Product Name and price fetched from UI and saved in HashMap as:" + map_final_products.toString()
					+ "<br>");
			// Find the Highest and Lowest prices
			Set<Float> allkeys = map_final_products.keySet();
			ArrayList<Float> array_list_values_product_prices = new ArrayList<Float>(allkeys);
			// Sort the Prices in Array List using Collections class
			Collections.sort(array_list_values_product_prices);
			// Highest Product is
			high_price = array_list_values_product_prices.get(array_list_values_product_prices.size() - 1);
			// Low price is
			Float low_price = array_list_values_product_prices.get(0);
			Log.info(
					"High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price));
			Log.info("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price));
		    assertTrue(high_price!=null);
		    assertTrue(low_price!=null);
		} catch (Exception | AssertionError e) {
			Log.info(e.getMessage());
		}
		return high_price;

	}
}