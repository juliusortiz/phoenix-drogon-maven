package StepClasses;

import Utility.Hook;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginDriver {

    private final WebDriver driver;

    public LoginDriver() {
        this.driver = Hook.getDriver();
    }

    @Given("^logged in as driver user$")
    public void loggedInAsDriverUser() throws IOException, InterruptedException {

        System.out.println("Test launching");

    }
}
