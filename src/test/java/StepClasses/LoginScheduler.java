package StepClasses;

import Utility.Hook;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginScheduler {

    private final WebDriver driver;

    public LoginScheduler() {
        this.driver = Hook.getDriver();
    }

    @Given("^logged in as Scheduler user$")
    public void loggedInAsSchedulerUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("sch.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Bulk Shipment Type dropdown from the dashboard$")
    public void navigateToBulkShipmentTypeDropdownFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]")).click(); //bulk shipment type
        WebElement BulkShipmentType = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]"));
        Assert.assertTrue(BulkShipmentType.isDisplayed());
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to TTP dropdown from the dashboard$")
    public void navigateToTTPDropdownFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div[2]/div[1]/div/div[2]")).click(); //ttp
        WebElement TTP = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div[2]/div[1]/div/div[2]"));
        Assert.assertTrue(TTP.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div[2]/div[1]/div/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Vehicle Code dropdown from the dashboard$")
    public void navigateToVehicleCodeDropdownFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]")).click(); //vehicle code
        WebElement VehicleCode = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"));
        Assert.assertTrue(VehicleCode.isDisplayed());
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Current Delivery page$")
    public void navigateToDispatcherPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click(); //dispatcher page
        WebElement CurrentDelivery = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"));
        Assert.assertTrue(CurrentDelivery.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Track Delivery page from the Current Delivery page$")
    public void navigateToTrackDeliveryPageFromTheDispatcherPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div/table/tbody/tr[1]/td[6]/a")).click(); //track delivery
        WebElement TrackDelivery = driver.findElement(By.xpath("/html/body/div[2]/main/section"));
        Assert.assertTrue(TrackDelivery.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Problems Reported Page$")
    public void navigateToProblemsReportedPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")).click(); //dispatcher page
        WebElement ProblemsReportedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div"));
        Assert.assertTrue(ProblemsReportedpage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Manage Reasons Page$")
    public void navigateToManageReasonspage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")).click(); //manage reasons page
        WebElement ManageReasonspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"));
        Assert.assertTrue(ManageReasonspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Scheduler Settings page$")
    public void navigateToSchedulerSettingsPage() throws InterruptedException {
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

    @And("^navigate to Scheduler notification page$")
    public void navigateToSchedulerNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
}
