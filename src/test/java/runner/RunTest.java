package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDefinition",
        tags = "@empty", //use and,or to more spesific tags
        plugin = {"pretty", "html:target/HtmlReport/signup.html"}
)
public class RunTest {
}
