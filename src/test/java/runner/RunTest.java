package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDefinition",
        tags = "@all", //use and,or to more spesific tags
        plugin = {"pretty", "html:target/HtmlReport/all.html"}
)
public class RunTest {
}
