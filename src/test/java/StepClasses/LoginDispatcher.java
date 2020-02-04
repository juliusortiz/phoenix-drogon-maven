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

public class LoginDispatcher extends BaseUtil {

    @Given("^logged in as dispatcher user$")
    public void loggedInAsDispatcherUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("dp.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       Thread.sleep(5000);
    }

    @And("^navigate to Problems Reported page$")
    public void navigateToProblemsReportedPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span")).click(); //problems reported page
        WebElement problemsreportedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span")); //
        Assert.assertTrue(problemsreportedpage.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Dispatcher Settings page$")
    public void navigateToDispatcherSettingsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //dropdown
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a")).click(); //settings page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Dispatcher Notification page$")
    public void navigateToDispatcherNotificationPage() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
            WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
            Assert.assertTrue(notificationpage.isDisplayed());
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Then("^Dispatcher Logout$")
    public void dispatcherLogout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //logout page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")); //
        Assert.assertTrue(logoutpage.isDisplayed());

        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
