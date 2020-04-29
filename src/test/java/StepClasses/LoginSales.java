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

public class LoginSales extends BaseUtil {

    WebDriverWait wait = new WebDriverWait(driver,50);

    @Given("^logged in as Sales user$")
    public void loggedInAsSalesUser() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("login.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText("Phoenix Petroleum");

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("sl.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Filter Dropdown from the dashboard$")
    public void navigateToFilterDropdownFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]"))).click(); //ser client
        WebElement filterdropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")); //ser client
        Assert.assertTrue(filterdropdown.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]"))).click(); //ser client
    }

    @And("^navigate to Today Dropdown from the dashboard$")
    public void navigateToTodayDropdownFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]"))).click();
        WebElement todaydropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]")); //today dropdown
        Assert.assertTrue(todaydropdown.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]"))).click(); //today dropdown
    }

    @And("^navigate to Products page from the dashboard$")
    public void navigateToProductsPageFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/main/div[1]/table/tbody/tr[1]/td[5]/button"))).click();
        WebElement productsbutton = driver.findElement(By.xpath("/html/body/div[2]/main/section/main/div[1]/table/tbody/tr[1]/td[5]/button")); //products
        Assert.assertTrue(productsbutton.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div[2]/div/div/div[3]/button"))).click(); //close
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to View Delivery Receipt from the dashboard$")
    public void navigateToViewDeliveryReceiptFromTheDashboard() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/main[1]/section[1]/main[1]/div[1]/table[1]/tbody[1]/tr[1]/td[6]/a[1]"))).click();
        WebElement VDRbutton = driver.findElement(By.xpath("/html/body/div[2]/main/section")); //VDR button
        Assert.assertTrue(VDRbutton.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/header/button"))).click(); //back
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Sales Delivery Status page$")
    public void navigateToSalesDeliveryStatusPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div"))).click(); //delivery status
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")); //
        Assert.assertTrue(history.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Sales History page$")
    public void navigateToSalesHistoryPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div"))).click(); //sales history
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")); //history
        Assert.assertTrue(history.isDisplayed());

    }

    @And("^navigate to Filter Dropdown from the Sales history page$")
    public void navigateToFilterDropdownFromTheSalesHistoryPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]"))).click(); //filter dropdown
        WebElement filterdropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")); //filter dropdown
        Assert.assertTrue(filterdropdown.isDisplayed());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/ html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]"))).click(); //filter dropdown
    }

    @And("^navigate to View Details from the Sales history page$")
    public void navigateToViewDetailsFromTheSalesHistoryPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/main/table/tbody/tr[1]/td[6]/a"))).click();
        WebElement VDRbutton = driver.findElement(By.xpath("/html/body/div[2]/main/section")); //VDR button
        Assert.assertTrue(VDRbutton.isDisplayed());
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/header/button")).click(); //back
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Sales Manage Accounts page$")
    public void navigateToMyAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[1]/span"))).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div"))).click();
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")); // manage accounts
        Assert.assertTrue(history.isDisplayed());
    }

    @And("^navigate to Shippings from Sales Manage Accounts page$")
    public void navigateToShippingsFromSalesManageAccountsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[1]/table/tbody/tr[1]/td[6]/a"))).click(); //shippings
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/main"));
        Assert.assertTrue(history.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/table/tbody/tr[1]/td[5]/button"))).click(); //location
    }

    @And("^navigate to Sales Settings page$")
    public void navigateToSalesSettingsPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/button[2]/img"))).click(); //dropdown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/article/footer/section[1]/a"))).click(); //settings page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]"))).click(); //send feedback
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]"))).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
    }

    @And("^navigate to Sales Notification page$")
    public void navigateToSalesNotificationPage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/header/a[2]/span"))).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
    }
}
