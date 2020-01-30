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

public class LoginCustomer1 extends SetUp {
    @Given("^logged in as customer user$")
    public void loggedInAsCustomerUser() throws IOException, InterruptedException {
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
                .sendKeys(String.valueOf(sheet.getRow(2).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login Customer = PASSED" + RESET);
        System.out.println();
           /* WebElement Header = driver.findElement(By.xpath(String.valueOf(sheet.getRow(2).getCell(4))));
        Assert.assertTrue(Header.isDisplayed());
        System.out.println("Login Customer = PASSED");
        driver.quit();*/
    }

    @And("^navigate to Delivery Status page$")
    public void navigateToDeliveryStatusPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")).click(); //delivery status page
        WebElement deliverystatuspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")); //
        Assert.assertTrue(deliverystatuspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery Status Page = PASSED" + RESET);
        System.out.println();
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
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery Receipts Page = PASSED" + RESET);
        System.out.println();
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
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to History Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to CDSS Profile page$")
    public void navigateToCDSSProfilePage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[5]/div/div")).click(); //cdss profile page
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[2]")).click(); //create a new cdss
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")).click(); //terms and condition
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/button[3]")); //
        Assert.assertTrue(historypage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to CDSS Profile Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Customer Settings page$")
    public void navigateToCustomerSettingsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/footer/div/section[1]/a/span")).click(); //settings page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Settings Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Customer Notification page$")
    public void navigateToCustomerNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }


    @Then("^Cutomer Logout$")
    public void cutomerLogout() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")); //
        Assert.assertTrue(logoutpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Logout Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/footer/div/section[2]/button/span")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.quit();
    }
}