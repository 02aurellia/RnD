package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "Background",
        tags = "@searchwithbg", //use and,or to more spesific tags
        plugin = {"pretty", "html:target/HtmlReport/searchwithbg.html"}
)
public class RunTest {
}
