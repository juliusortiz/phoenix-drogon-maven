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

public class LoginCustomer extends BaseUtil {

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
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

    }

    @And("^navigate to Delivery Status page$")
    public void navigateToDeliveryStatusPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")).click(); //delivery status page
        WebElement deliverystatuspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")); //
        Assert.assertTrue(deliverystatuspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Delivery Receipt page$")
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
    }

    @And("^navigate to History page$")
    public void navigateToHistoryPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[1]")).click(); //all
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[4]/div/div")).click(); //history page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[2]")).click(); //successfull
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")).click(); //rejected
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")); //
        Assert.assertTrue(historypage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to CDSS Profile page$")
    public void navigateToCDSSProfilePage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[5]/div/div")).click(); //cdss profile page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[2]")).click(); //create a new cdss
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")).click(); //terms and condition
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")); //
        Assert.assertTrue(historypage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Customer Settings page$")
    public void navigateToCustomerSettingsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img")).click(); //dropdown
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/article/footer/section[1]/a")).click(); //settings page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Customer Notification page$")
    public void navigateToCustomerNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")); //
        Assert.assertTrue(notificationpage.isDisplayed());
       Thread.sleep(4000);
    }

    @Then("^Customer Logout page$")
    public void customerLogoutPage() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img")).click(); //logout page
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/button/img"));
            Assert.assertTrue(logoutpage.isDisplayed());

            driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/div/article/footer/section[2]/label")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}



