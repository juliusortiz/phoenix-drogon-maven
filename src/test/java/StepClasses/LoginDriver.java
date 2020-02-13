package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.Given;

import java.io.IOException;

public class LoginDriver extends BaseUtil {


    @Given("^logged in as driver user$")
    public void loggedInAsDriverUser() throws IOException, InterruptedException {

        System.out.println("Test launching");

    }
}
