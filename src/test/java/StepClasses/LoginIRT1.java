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
import org.testng.reporters.jq.INavigatorPanel;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

public class LoginIRT1 extends SetUp {
    @Given("^logged in as IRT user$")
    public void loggedInAsIRTUser() throws IOException, InterruptedException {
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
                .sendKeys(String.valueOf(sheet.getRow(4).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login IRT = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       /* WebElement Header = driver.findElement(By.xpath(String.valueOf(sheet.getRow(2).getCell(4))));
        Assert.assertTrue(Header.isDisplayed());
        System.out.println("Login Customer = PASSED");
        driver.quit();*/
    }

    @And("^navigate to In Transit Orders page$")
    public void navigateToInTransitOrdersPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click(); //in transit orders tab
        WebElement intransitorderspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")); //
        Assert.assertTrue(intransitorderspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to In-Transit Orders Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Accepted Orders page$")
    public void navigateToAcceptedOrdersPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")).click(); //accepted orders tab
        WebElement acceptedorderspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")); //
        Assert.assertTrue(acceptedorderspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Accepted Orders Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Image Submitted page$")
    public void navigateToImageSubmittedPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")).click(); //image submitted page
        WebElement imagesubmittedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")); //
        Assert.assertTrue(imagesubmittedpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Image Submitted Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to IRT Settings Page$")
    public void navigateToIRTSettingsPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/a")).click(); //settings page
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

    @And("^navigate to IRT Notification page$")
    public void navigateToIRTNotificationPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Then("^IRT Logout$")
    public void irtLogout() throws InterruptedException {
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
