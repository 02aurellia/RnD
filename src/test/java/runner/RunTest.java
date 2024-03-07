package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "StepDefinition", tags = "@negative", // use and,or to more spesific tags
		  		 plugin = { "pretty", "html:target/HtmlReport/positive.html",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class RunTest {
}
