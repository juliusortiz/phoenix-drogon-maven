package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginAdmin extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);
    FileInputStream login = new FileInputStream(getClass().getClassLoader().getResource("login.properties").getFile());
    FileInputStream admin = new FileInputStream(getClass().getClassLoader().getResource("admin.properties").getFile());
    Properties loginprop = new Properties();
    Properties adminprop = new Properties();

    public LoginAdmin() throws FileNotFoundException {
        System.out.println("The property file did not load");
    }

    @Given("^logged in as Admin user$")
    public void loggedInAsAdminUser() throws IOException {
        loginprop.load(login);

        Select businesstype = new Select(driver.findElement(By.xpath(loginprop.getProperty("businesstypedropdown"))));
        businesstype.selectByVisibleText("Phoenix Petroleum");
        driver.findElement(By.xpath(loginprop.getProperty("usernameField")))
                .sendKeys(loginprop.getProperty("sa.username"));
        driver.findElement(By.xpath(loginprop.getProperty("passwordField")))
                .sendKeys(loginprop.getProperty("password"));
        driver.findElement(By.xpath(loginprop.getProperty("loginButton"))).click();
    }

    @And("^navigate to Users page from the dashboard$")
    public void navigateToUsersPageFromTheDashboard() throws InterruptedException, IOException {
        adminprop.load(admin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(adminprop.getProperty("userspage")))).click(); //users
        WebElement Customerspage = driver.findElement(By.xpath(adminprop.getProperty("userspageheader")));
        Assert.assertTrue(Customerspage.isDisplayed());
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[1]/img"))).click(); //home
        Thread.sleep(2000);
    }

    @And("^navigate to Delivery Status page from the dashboard$")
    public void navigateToDeliveryStatusPageFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/header[1]/a[1]/img[1]"))).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/section[1]/div[1]/header[1]/a[1]"))).click();
        WebElement DeliveryStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/header[1]/span[1]"));
        Assert.assertTrue(DeliveryStatusHeader.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Users page$")
    public void navigateToManageUsersPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]"))).click(); //manage users
        Thread.sleep(2000);
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
    }

    @And("^navigate to Create User page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/button"))).click(); //create user
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span"))).click(); //close
    }

    @And("^navigate to Statuses page$")
    public void navigateToStatusesPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]"))).click(); //manage status
        WebElement Statuses = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(Statuses.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to My Accounts page$")
    public void navigateToMyAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"))).click(); //manage accounts
        WebElement ManageAccountspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"));
        Assert.assertTrue(ManageAccountspage.isDisplayed());
    }

    @And("^navigate to Shippings from Manage Accounts page$")
    public void navigateToShippingsFromManageAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[1]/table/tbody/tr[1]/td[6]/a"))).click(); //shippings
        WebElement shippingspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(shippingspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div/a"))).click(); //close
    }

    @And("^navigate to Delivery Status page$")
    public void navigateToDeliveryStatusPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[5]/div/div"))).click(); //delivery receipts
        WebElement DeliveryReceipts = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[5]/div/div"));
        Assert.assertTrue(DeliveryReceipts.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^open Delivery Instructions modal$")
    public void openDeliveryInstructionsModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/button[1]"))).click();
        WebElement InstructionsModal = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[2]/h5[1]"));
        Assert.assertTrue(InstructionsModal.isDisplayed());
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[1]/button[1]/span[1]")))).click();
    }

    @And("^open Products modal$")
    public void openProductsModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[8]/button[1]"))).click();
        WebElement ProductsModal = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[1]/h5[1]"));
        Assert.assertTrue(ProductsModal.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[1]/button[1]/span[1]"))).click();
    }

    @And("^open Current Status modal$")
    public void openCurrentStatusModal() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[9]/button[1]"))).click();
        WebElement CurrentStatusModal = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[1]/h5[1]"));
        Assert.assertTrue(CurrentStatusModal.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[4]/div[1]/div[1]/div[1]/button[1]"))).click();
    }

    @And("^view location$")
    public void viewLocation() {
        WebElement location = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/button[1]"));
        Actions build = new Actions(driver);
        build.moveToElement(location).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[11]/button[1]"))).click();
        WebElement Mapdropdown = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]"));
        Assert.assertTrue(Mapdropdown.isDisplayed());
    }

    @And("^open Delivery Receipt modal$")
    public void openDeliveryReceiptModal() {
        WebElement DeliveryReceipt = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[1]/button[1]"));
        Actions build = new Actions(driver);
        build.moveToElement(DeliveryReceipt).build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[12]/a[1]/button[1]")));
    }

    @And("^navigate to Admin Manage Reasons Page$")
    public void navigateToAdminManageReasonsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div/div"))).click();
        WebElement ProblemsReportedAndBackloads = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[6]/div"));
        Assert.assertTrue(ProblemsReportedAndBackloads.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[1]/button"))).click(); //add new reason
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[1]/div[1]/button[1]"))).click(); //close
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[2]/div/div[1]/div[2]"))).click(); //backload
        Thread.sleep(2000);
    }

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
