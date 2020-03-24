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

public class LoginInvoicingClerk extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);

    @Given("^logged in as Invoicing Clerk user$")
    public void loggedInAsInvoicingClerkUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("ic.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='login100-form-btn']"))).click();
    }

    @And("^navigate to View Details page from the dashboard$")
    public void navigateToViewDetailsPageFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/a[1]/button[1]"))).click(); //view details page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/section"));
        Assert.assertTrue(Statuspage.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[1]/img"))).click(); //back
    }

    @And("^navigate to Invoicing Clerk notification page$")
    public void navigateToInvoicingClerkNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[2]/span"))).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
    }


    @And("^navigate to Invoicing Clerk Settings page$")
    public void navigateToInvoicingClerkSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button/img"))).click(); //dropdown
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a"))).click(); //settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]"))).click(); //send feedback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"))).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"));
        Assert.assertTrue(settingspage.isDisplayed());
    }
}