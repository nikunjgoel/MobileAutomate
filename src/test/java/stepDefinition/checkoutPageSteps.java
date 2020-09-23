package stepDefinition;

import java.util.HashMap;
import java.util.Map;
import cucumber.TestContext;
import cucumber.api.java.en.Then;
import enums.Context;
import pageClasses.CheckoutPage;

public class checkoutPageSteps {

	CheckoutPage checkOutPage;
	TestContext testContext;
	Map<String, String> testData = new HashMap<>();

	public checkoutPageSteps(TestContext context) {
		testContext = context;
		checkOutPage = testContext.getPageObjectManager().getCheckOutPage();

	}

	@Then("^user checkout the selected item from checkout page$")
	public void checkoutItem() {
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		String Product =testContext.scenarioContext.getContext(Context.PRODUCTNAME).toString();
		checkOutPage.addItemToCheckout(testData,Product);

	}
	
}
