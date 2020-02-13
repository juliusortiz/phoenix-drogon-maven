package Utility;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.appium.java_client.android.AndroidDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hook {
    private static WebDriver driver;

    @Before("@Web")
    public void InitializeTest() throws IOException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        driver.get(prop.getProperty("base.URL"));
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @Before("@App")
    public void InitializeAndroid() throws IOException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "H9AXHM01P645XNH");
        caps.setCapability("platformName", "Android");
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("app", "C:\\xampp\\htdocs\\Phoenix-drogon-gradle\\AppRelease\\app-release02-10-20.apk");
        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Then("^Logout page$")
    public void logoutPage() {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button/img")).click(); //logout page
        driver.manage().timeouts().implicitlyWait(50 TimeUnit.SECONDS);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/button/img"));
        Assert.assertTrue(logoutpage.isDisplayed());

        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @After("@Web")
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }

    @After("@App")
    public void TearDownAndroid(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
