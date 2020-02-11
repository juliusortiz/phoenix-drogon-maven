package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features",
        glue = {"Hooks","StepClasses"},
        tags = "@SmokeTest1",
        plugin = { "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"
        })

public class TestRunner {

}
