package stepDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import enums.Context;
import helper.Config;
import helper.TestBase;
import pageClasses.LoginPage;

public class LoginPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	Map<String, String> testData = new HashMap<>();

	public LoginPageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();

	}

	@When("^User Login with \"([^\"]*)\" Credentials$")
	public void userLoginwithCredentials(String User) {

		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
	   loginPage.login(testData.get("username"), testData.get("Password"));
	}
	@When("^User Login with invalid Credentials$")
	public void userLoginwithInvalidCredentials() {

		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
	   loginPage.inValidlogin(testData.get("invalidUserName"), testData.get("invalidPassword"), testData.get("validemail"), testData.get("invalidphone"),testData.get("validpassword"));
	}
	@When("^User validate invalid workflow$")
	public void verifyInvalidCredentials() {

		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
	   loginPage.verifyInValidlogin(testData.get("invalidUserName"), testData.get("invalidPassword"), testData.get("validemail"), testData.get("invalidphone"),testData.get("validpassword"));
	}
	
}
