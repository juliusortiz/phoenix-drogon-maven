package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginAdmin extends BaseUtil {


    @Given("^logged in as admin user$")
    public void loggedInAsAdminUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("sa.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to status page from the dashboard$")
    public void navigateToStatusPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[1]/a/div")).click(); //status page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Statuspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to customer page from the dashboard$")
    public void navigateToCustomerPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[2]/a")).click(); //customer page
        WebElement Customerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Customerpage.isDisplayed());
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        Thread.sleep(500);
    }

    @And("^navigate to Manage Users page$")
    public void navigateToManageUsersPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Create User page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @And("^navigate to Manage Status page$")
    public void navigateToManageStatusPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]")).click(); //status
        WebElement ManageStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageStatusHeader.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Manage Customer page$")
    public void navigateToManageCustomerPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[4]/div[1]")).click(); //manage customer
        WebElement ManageCustomerHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageCustomerHeader.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Delivery Receipts page$")
    public void navigateToDeliveryReceiptsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[6]/div[1]")).click(); // delivery receipts //all
        WebElement DeliveryReceipts = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(DeliveryReceipts.isDisplayed());
        Thread.sleep(500);
    }

    @And("^navigate to Problems Reported and Backloads Page$")
    public void navigateToProblemsReportedAndBackloadsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div")).click(); //problems and back reloads
        WebElement ProblemsReportedAndBackloads = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div"));
        Assert.assertTrue(ProblemsReportedAndBackloads.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/button")).click(); //add new reason
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div/div/div/div[2]/div")).click(); //backload
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Settings Page$")
    public void navigateToSettingsPage() throws InterruptedException {
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

    @And("^navigate to Notification Page$")
    public void navigateToNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
