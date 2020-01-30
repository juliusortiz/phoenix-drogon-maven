package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = "StepClasses",
        tags = "@SmokeTest3",
        plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"
        })

public class TestRunner {

}
