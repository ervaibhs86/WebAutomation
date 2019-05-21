package TestRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome=true,
		features="Feature",
		glue={"TestCases"},
		dryRun=false,
		plugin={"pretty","html:target/cucumber-html-report"},
		tags={"@PersonalInfo,@PlaceOrder"}, //OR condition(It will execute if any of the tag is there)
		strict=false
		)
public class TestRunner {

}