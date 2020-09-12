/*package stepDefinition;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import helper.Config;
import helper.ExtentManager;
public class Hooks extends AbstractTestNGCucumberTests {
	public static String browsers;
	ExtentTest test;
	@Parameters({ "browser","env" ,"siteUrl"})
	@BeforeTest
	public void setUpScenario(String browser, String env, String siteUrl) {
		browsers = browser;
		Config.Environment = env;
		Config.siteUrl = siteUrl;
	}
	
	@AfterTest
	public void generateReport() {
		ExtentManager._extent.endTest(test);
		ExtentManager._extent.flush();
	}
}
*/

package stepDefinition;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.LogStatus;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helper.Config;
import helper.GenUtility;
import helper.Log;
public class Hooks {
	TestContext testContext;
	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void setUpScenario() {
			testContext.init();
				}

	@After
	public void tearDown(Scenario scenario) {
		LogStatus status;
		if (scenario.isFailed()) {
			status = LogStatus.FAIL;
		} else
			status = LogStatus.PASS;
		String path = GenUtility.takeScreenshot(testContext.getDriver());

		testContext.getExtentTest().log(status,
				"Screenshot below: " + testContext.getExtentTest().addScreenCapture(path));
		testContext.quitBrowser();
		testContext.closeTest();
		Log.endLog("Log end");

	}
}
