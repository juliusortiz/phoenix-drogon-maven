package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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

public class LoginCustomer extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);

    @Given("^logged in as customer user$")
    public void loggedInAsCustomerUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("cus.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        Thread.sleep(10000);
    }

    @And("^navigate to Customer Delivery Status page$")
    public void navigateToCustomerDeliveryStatusPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span"))).click(); //dashboard
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div"))).click(); //delivery status page
        WebElement deliverystatuspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")); //
        Assert.assertTrue(deliverystatuspage.isDisplayed());
        Thread.sleep(1000);
    }

    @And("^navigate to View Delivery Receipt from the Delivery Status$")
    public void navigateToViewDeliveryReceiptFromTheDeliveryStatus() throws InterruptedException {

    }

  /*  @And("^navigate to Delivery Receipt page$")
    public void navigateToDeliveryReceiptPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[3]/div/div")).click(); //delivery receipts page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[2]")).click(); //successfull
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")).click(); //rejected
        WebElement deliveryreceiptspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")); //
        Assert.assertTrue(deliveryreceiptspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }*/

    @And("^navigate to Customer History page$")
    public void navigateToCustomerHistoryPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span"))).click(); //dashboard
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[3]/div/div"))).click(); //history
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[3]/div/div")); //
        Assert.assertTrue(historypage.isDisplayed());
        Thread.sleep(3000);
    }
    @And("^navigate to Filter Dropdown from the Customer History page$")
    public void navigateToFilterDropdownFromTheCustomerHistoryPage() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]"))).click(); //filter dropdown
        WebElement filterdropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")); //filter dropdown
        Assert.assertTrue(filterdropdown.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/ html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]"))).click(); //filter dropdown
    }

    @And("^navigate to Today Dropdown from the Customer History page$")
    public void navigateToTodayDropdownFromTheCustomerHistoryPage() throws InterruptedException {

    }

    @And("^navigate to View Details from the Customer history page$")
    public void navigateToViewDetailsFromTheCustomerHistoryPage() throws InterruptedException {
    }

    @And("^navigate to CDSS Profile page$")
    public void navigateToCDSSProfilePage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[1]/button"))).click(); //dashboard
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[4]/div/div"))).click(); //cdss profile page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/button[2]"))).click(); //create a new cdss
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/button[3]"))).click(); //terms and condition
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")); //
        Assert.assertTrue(historypage.isDisplayed());
    }

    @And("^navigate to Customer Settings page$")
    public void navigateToCustomerSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img"))).click(); //dropdown
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/article/footer/section[1]/a"))).click(); //settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]"))).click(); //send feedback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"))).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
    }

    @And("^navigate to Customer Notification page$")
    public void navigateToCustomerNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a"))).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        Thread.sleep(2000);
    }

    @Then("^Customer Logout page$")
    public void customerLogoutPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img"))).click(); //logout page
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img"));
        Assert.assertTrue(logoutpage.isDisplayed());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/article/footer/section[2]/label"))).click();
    }
}



