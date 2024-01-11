package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "POM",
        tags = "@signup and @negative", //use and,or to more spesific tags
        plugin = {"pretty", "html:target/HtmlReport/SignUpPOM.html"}
)

public class RunnerPOM {
    
}
