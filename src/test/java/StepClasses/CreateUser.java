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

public class CreateUser extends SetUp {
    @Given("^logged in as Admin user$")
    public void loggedInAsAdminUser()  throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //   options.addArguments("--headless");
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
       Thread.sleep(5000);
    }

    @And("^navigate to Manage users page$")
    public void navigateToManageUsersPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Users page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Create user page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Users page = PASSED" + RESET);
        System.out.println();
    }

    @And("^create a dispatcher user from create user page$")
    public void createADispatcherUserFromCreateUserPage() throws InterruptedException {
        driver.findElement(By.id("username"))
                .sendKeys("lesterjohnjimenez");
        driver.findElement(By.id("email"))
                .sendKeys("lester.qaintern@dice205.com");
        driver.findElement(By.id("first_name"))
                .sendKeys("Lester John");
        driver.findElement(By.id("last_name"))
                .sendKeys("Jimenez");
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[1]/div[5]/div/div/div[1]/div/div[2]")).click(); //role
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[1]/div[5]/div/div/div[2]/div/div[4]")).click(); //role
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[2]/button")).click(); //create
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Then("^admin logout page$")
    public void adminLogoutPage() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //logout page
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")); //
            Assert.assertTrue(logoutpage.isDisplayed());
            System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Logout Page = PASSED" + RESET);
            System.out.println();

            driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.quit();
        }
    }

