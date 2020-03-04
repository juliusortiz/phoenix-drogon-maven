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

public class LoginDispatcher extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);

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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='login100-form-btn']"))).click();
        Thread.sleep(5000);
    }

    @And("^navigate to Delivery Instructions from the dashboard page$")
    public void navigateToDeliveryInstructionsFromTheDashboardPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div/table/tbody/tr[1]/td[6]/button"))).click(); //delivery instructions
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div/table/tbody/tr[1]/td[6]/button"));
        Assert.assertTrue(Statuspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div/div/div/div[1]/button"))).click(); //close
    }

    @And("^navigate to Track Delivery page from the dashboard page$")
    public void navigateToTrackDeliveryPageFromTheDashboardPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div/table/tbody/tr[1]/td[7]/a/div"))).click(); //track delivery
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/section"));
        Assert.assertTrue(Statuspage.isDisplayed());
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/a"))).click(); //back
    }


    @And("^navigate to Deliveries History$")
    public void navigateToDeliveriesHistory() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"))).click(); //problems reported page
        WebElement deliverieshistory = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"));
        Assert.assertTrue(deliverieshistory.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Problems Reported page$")
    public void navigateToProblemsReportedPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span"))).click(); //problems reported page
        WebElement problemsreportedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span")); //
        Assert.assertTrue(problemsreportedpage.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Reasons page$")
    public void navigateToManageReasonsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"))).click(); //manage reasons page
        WebElement managereasonspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")); //
        Assert.assertTrue(managereasonspage.isDisplayed());
    }

    @And("^navigate to Add New Reason from the Manage Reasons page$")
    public void navigateToAddNewReasonFromTheManageReasonsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[1]/button"))).click(); //add new reason
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[1]/button"));
        Assert.assertTrue(Statuspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button"))).click(); //close
    }

    @And("^navigate to Backload dropdown from the Manage Reasons page$")
    public void navigateToBackloadDropdownFromTheManageReasonsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[2]/div/div[1]/div[2]"))).click(); //backload dropdown
        WebElement backloaddropdown = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[2]/div/div[1]/div[2]")); //backload dropdown
        Assert.assertTrue(backloaddropdown.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div[2]/div/div[1]/div[2]"))).click(); //backload dropdown
    }

    @And("^navigate to Dispatcher Settings page$")
    public void navigateToDispatcherSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[2]/img"))).click(); //dropdown
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a"))).click(); //settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]"))).click(); //send feedback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"))).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"));
        Assert.assertTrue(settingspage.isDisplayed());
    }

    @And("^navigate to Dispatcher Notification page$")
    public void navigateToDispatcherNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[2]"))).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
    }
}
