package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = {"src/test/resources/features/CreateEntity.feature"}, glue = "stepDefinition",monochrome = true , tags = {"@CreateEntity"}, dryRun = false)
public class TestRunner  extends AbstractTestNGCucumberTests{

}; 