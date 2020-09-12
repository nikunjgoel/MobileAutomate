package cucumber;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import helper.ExtentManager;
import helper.GenUtility;
import helper.Log;
import io.appium.java_client.android.AndroidDriver;
import managers.PageObjectManager;
import managers.WebdriverInitializer;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestContext {
	private AndroidDriver<WebElement> driver;
	private ExtentReports _extent = ExtentManager.getInstance();
	private PageObjectManager pageObjectManager;
	private ExtentTest _test;
	public ScenarioContext scenarioContext;

	public TestContext() {
		scenarioContext = new ScenarioContext();
	}

	public ExtentTest getExtentTest() {
		return _test;
	}

	public AndroidDriver<WebElement> getDriver() {
		return driver;
	}

	public void setScenarioContext(ScenarioContext scenarioContext) {
		this.scenarioContext = scenarioContext;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

	public void setPageObjectManager(PageObjectManager pageObjectManager) {
		this.pageObjectManager = pageObjectManager;
	}

	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}

	public void closeTest() {
		_extent.endTest(_test);
		_extent.flush();
	}

	public void quitBrowser() {
		driver.quit();
	}

	public void startTest(String testName, String desc) {
		_test = _extent.startTest(testName, desc);
	}

	public void init() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File logdir = new File(classpathRoot, "/log/");
		File log4j = new File(logdir, "log4j.properties");

		System.out.println(log4j.getAbsolutePath());
		// String path=Config.log4jpath;
		PropertyConfigurator.configure(log4j.getAbsolutePath());
		Log.startLog("Logger started");

		driver = new WebdriverInitializer().init_driver();
		_test = _extent.startTest(GenUtility.getRandomAlphaNumString());
		setPageObjectManager(new PageObjectManager(driver, _test));
	}

}
