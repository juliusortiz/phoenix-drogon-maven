package StepClasses;

import Configuration.SetUp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class LoginAdmin extends SetUp {

    @Given("^logged in as admin user$")
    public void loggedInAsAdminUser() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        driver.get("https://phoenix_epod_app.dice205.asia/");
        driver.getWindowHandle();
        driver.manage().window().maximize();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Credentials.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(String.valueOf(sheet.getRow(1).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);


    /*    WebElement dashboardchart = driver.findElement(By.cssSelector(String.valueOf(sheet.getRow(1).getCell(5))));
        Assert.assertTrue(dashboardchart.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();*/
     //   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to status page from the dashboard$")
    public void navigateToStatusPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[1]/a/div")).click(); //status page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Statuspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Status page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to customer page from the dashboard$")
    public void navigateToCustomerPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[2]/a")).click(); //customer page
        WebElement Customerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Customerpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Customer page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @And("^navigate to truck driver page from the dashboard$")
    public void navigateToTruckDriverPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[3]/a")).click(); //customer page
        WebElement Truckdriverpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Truckdriverpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Truck Driver page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        Thread.sleep(2000);
    }

    @And("^navigate to Manage Users page$")
    public void navigateToManageUsersPage()  throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Users page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Create User page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers()  throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Users page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(500);

    }

    @And("^navigate to Manage Status page$")
    public void navigateToManageStatusPage() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]")).click(); //status
        WebElement ManageStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageStatusHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Status page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(500);
    }

    @And("^navigate to Manage Customer page$")
    public void navigateToManageCustomerPage() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[4]/div[1]")).click(); //manage customer
        WebElement ManageCustomerHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageCustomerHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Customer page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(500);
    }

    @And("^navigate to Create Customer page from Manage Customer$")
    public void navigateToCreateCustomerPageFromManageCustomer() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CreateCustomerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateCustomerpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Customer page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(500);
    }

    @And("^navigate to Manage Truck Drivers page$")
    public void navigateToManageTruckDriversPage() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[5]/div[1]")).click(); //manage truck drivers
        WebElement ManageTruckDriverHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageTruckDriverHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Truck Drivers page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(500);
    }

    @And("^navigate to Create Driver page from Manage Truck Drivers$")
    public void navigateToCreateDriverPageFromManageTruckDrivers() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement CreateDriverpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateDriverpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Driver page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(1000);
    }

    @And("^navigate to Delivery Receipts page$")
    public void navigateToDeliveryReceiptsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[6]/div[1]")).click(); // delivery receipts //all
        WebElement DeliveryReceipts = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(DeliveryReceipts.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Delivery Receipts page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(3000);
    }

    @And("^navigate to Problems Reported and Backloads Page$")
    public void navigateToProblemsReportedAndBackloadsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[7]/div")).click(); //problems and back reloads
        WebElement ProblemsReportedAndBackloads = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[7]/div"));
        Assert.assertTrue(ProblemsReportedAndBackloads.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Problems Reported And Backloads page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/button")).click(); //add new reason
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div/div/div/div[2]/div")).click(); //backload
        Thread.sleep(500);
    }

    @And("^navigate to Settings Page$")
    public void navigateToSettingsPage() throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/a")).click(); //settings page
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Settings Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
    }

    @And("^navigate to Notification Page$")
    public void navigateToNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Then("^Logout page$")
    public void logoutPage() {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //logout page
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")); //
        Assert.assertTrue(logoutpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Logout Page = PASSED" + RESET);
        System.out.println();

        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.quit();
    }
}
