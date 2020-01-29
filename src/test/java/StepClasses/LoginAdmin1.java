package StepClasses;

import Configuration.SetUp;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.net.iharder.Base64;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class LoginAdmin1 extends SetUp {

    @Given("^logged in as admin user$")
    public void loggedInAsAdminUser() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//      options.addArguments("--headless");
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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();


    /*    WebElement dashboardchart = driver.findElement(By.cssSelector(String.valueOf(sheet.getRow(1).getCell(5))));
        Assert.assertTrue(dashboardchart.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^navigate to status page from the dashboard$")
    public void navigateToStatusPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[1]/a/div")).click(); //status page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Statuspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Status page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]")).click(); //home
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^navigate to customer page from the dashboard$")
    public void navigateToCustomerPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[2]/a")).click(); //customer page
        WebElement Customerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Customerpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Customer page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^navigate to truck driver page from the dashboard$")
    public void navigateToTruckDriverPageFromTheDashboard() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[3]/a")).click(); //customer page
        WebElement Truckdriverpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Truckdriverpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Truck Driver page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @And("^navigate to Manage Users page$")
    public void navigateToManageUsersPage()  throws InterruptedException{
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Users page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }




    @Then("^Logout$")
    public void logout() throws InterruptedException{
        driver.quit();
    }
}
