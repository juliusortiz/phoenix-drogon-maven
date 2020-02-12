package Hooks;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Hooks extends BaseUtil {

    @Before
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

    @Then("^Logout page$")
    public void logoutPage() {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button/img")).click(); //logout page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/button/img"));
        Assert.assertTrue(logoutpage.isDisplayed());

        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @After
    public void TearDownTest(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        driver.quit();
    }
}
