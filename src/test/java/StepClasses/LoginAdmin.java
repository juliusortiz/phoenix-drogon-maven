package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginAdmin extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,30);

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
    }

    @And("^navigate to status page from the dashboard$")
    public void navigateToStatusPageFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/section/button[1]/a/div/div[2]/span[1]"))).click();
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Statuspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[1]/img"))).click();
    }

    @And("^navigate to customer page from the dashboard$")
    public void navigateToCustomerPageFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/section/button[2]/a"))).click();
        WebElement Customerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Customerpage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[1]/img"))).click();
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Users page$")
    public void navigateToManageUsersPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]"))).click();
        Thread.sleep(2000);
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
    }

    @And("^navigate to Create User page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/button"))).click();
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span"))).click();
    }

    @And("^navigate to Manage Statuses page$")
    public void navigateToManageStatusesPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]"))).click();
        WebElement ManageStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageStatusHeader.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Accounts page$")
    public void navigateToManageAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"))).click();
        WebElement ManageAccountspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"));
        Assert.assertTrue(ManageAccountspage.isDisplayed());
    }

    @And("^navigate to Shippings from Manage Accounts page$")
    public void navigateToShippingsFromManageAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[1]/table/tbody/tr[1]/td[6]/a"))).click();
        WebElement shippingspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(shippingspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div/a"))).click();
    }

    @And("^navigate to Delivery Receipts page$")
    public void navigateToDeliveryReceiptsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[6]/div[1]"))).click();
        WebElement DeliveryReceipts = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(DeliveryReceipts.isDisplayed());
    }
/*  And navigate to Products from Delivery Receipts page
    @And("^navigate to Products from Delivery Receipts page$")
    public void navigateToProductsFromDeliveryReceiptsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[1]/table/tbody/tr[1]/td[11]/button")).click(); //shippings
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div"));
        Assert.assertTrue(history.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div/div[3]/button")).click(); //close
    } */

   /* @And("^navigate to Problems Reported and Backloads Page$")
    public void navigateToProblemsReportedAndBackloadsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div"))).click();
        Thread.sleep(2000);
        WebElement ProblemsReportedAndBackloads = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div"));
        Assert.assertTrue(ProblemsReportedAndBackloads.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/button")).click(); //add new reason
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button")).click(); //close
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div/div/div/div[2]/div")).click(); //backload
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }*/

    @And("^navigate to Settings Page$")
    public void navigateToSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[2]/img"))).click();
        Thread.sleep(2000);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a")).click(); //settings page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());

    }

    @And("^navigate to Notification Page$")
    public void navigateToNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[2]"))).click();
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
    }
}
