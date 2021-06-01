package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




		 
	@RunWith(Cucumber.class)
	@CucumberOptions(
		    features = "Features",
		    glue = {"stepDefinitions"},
		    tags = "@Activity5",
		    plugin= {"pretty", "html:target/cucumber_reports/reports"},
		    monochrome=true
		)
		 
		public class TestRunner {
		    //empty
		}

