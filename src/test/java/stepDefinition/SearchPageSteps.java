package stepDefinition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import enums.Context;
import pageClasses.SearchPage;

public class SearchPageSteps  {
	TestContext testContext;
	SearchPage searchPage;
	Map<String, String> testData = new HashMap<>();
	String product;
    String price;
	public SearchPageSteps(TestContext context) {
		testContext = context;
		searchPage = testContext.getPageObjectManager().getSearchPage();

	}


	
	@And("^user Enter product in search details page$")
	public void searchProductFromSearchBox() {
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		product= searchPage.searchProduct(testData);
		testContext.scenarioContext.setContext(Context.PRODUCTNAME,
				product);

	}

	
	@Then("^user verify search result displayed in list and click the search data$")
	public void verifyAndClickSearchData() {
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		price=searchPage.verifyClickSearchData();
		testContext.scenarioContext.setContext(Context.PRICE, price);

	}
	

	@And("^user compare the price product$")
	public void compareHighestPriceforSearchedProduct() {
		testData = (Map<String, String>) testContext.scenarioContext.getContext(Context.TEST_DATA);
		searchPage.comparePrice(testData);
	}
}