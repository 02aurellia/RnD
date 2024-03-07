package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "Hooks", tags = "@All", // use and,or to more spesific tags
		         plugin = { "pretty", "html:target/HtmlReport/searchHooks.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

public class RunnerForHooks {

}
