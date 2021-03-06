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

public class LoginScheduler extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);

    @Given("^logged in as Scheduler user$")
    public void loggedInAsSchedulerUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("login.properties").getFile());
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]"))).click(); //bulk shipment type
        WebElement BulkShipmentType = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]"));
        Assert.assertTrue(BulkShipmentType.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[1]/div[1]/div/div[1]/div/div[2]"))).click();
    }

    @And("^navigate to TTP dropdown from the dashboard$")
    public void navigateToTTPDropdownFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"))).click(); //ttp
        WebElement TTP = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"));
        Assert.assertTrue(TTP.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"))).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Vehicle Code dropdown from the dashboard$")
    public void navigateToVehicleCodeDropdownFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"))).click(); //vehicle code
        WebElement VehicleCode = driver.findElement(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"));
        Assert.assertTrue(VehicleCode.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/section/div[1]/table/tbody/tr/td[2]/div/div/div[1]/div/div[2]"))).click();
    }

    @And("^navigate to Current Deliveries page$")
    public void navigateToCurrentDeliveriesPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"))).click(); //dispatcher page
        WebElement CurrentDelivery = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"));
        Assert.assertTrue(CurrentDelivery.isDisplayed());
    }

    @And("^navigate to Delivery Instructions$")
    public void navigateToDeliveryInstructions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/button[1]"))).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CurrentDelivery = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[2]/h5[1]"));
        Assert.assertTrue(CurrentDelivery.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/div[1]/div[1]/div[1]/button[1]"))).click();
    }

    @And("^navigate to Track Delivery page from the Current Deliveries page$")
    public void navigateToTrackDeliveryPageFromTheCurrentDeliveriesPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]"))).click(); //track delivery
        WebElement TrackDelivery = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/section[1]/article[1]/div[1]/header[1]/div[1]"));
        Assert.assertTrue(TrackDelivery.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/header[1]/a[1]"))).click();
        Thread.sleep(2000);
    }

    @And("^navigate to Problems Reported Page$")
    public void navigateToProblemsReportedPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div"))).click(); //dispatcher page
        WebElement ProblemsReportedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div"));
        Assert.assertTrue(ProblemsReportedpage.isDisplayed());
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Reasons Page$")
    public void navigateToManageReasonspage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]"))).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"))).click(); //manage reasons page
        WebElement ManageReasonspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"));
        Assert.assertTrue(ManageReasonspage.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Scheduler Settings page$")
    public void navigateToSchedulerSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[2]/img"))).click(); //dropdown
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a"))).click(); //settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]"))).click(); //send feedback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"))).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
    }

    @And("^navigate to Scheduler notification page$")
    public void navigateToSchedulerNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[2]"))).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
    }
}
