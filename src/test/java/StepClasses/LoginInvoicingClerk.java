package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginInvoicingClerk extends BaseUtil {

    @Given("^logged in as Invoicing Clerk user$")
    public void loggedInAsInvoicingClerkUser()  throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("ic.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to View Details page from the dashboard$")
    public void navigateToViewDetailsPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div[1]/table/tbody/tr[1]/td[8]/a/button")).click(); //view details page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/section"));
        Assert.assertTrue(Statuspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Invoicing Clerk notification page$")
    public void navigateToInvoicingClerkNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}