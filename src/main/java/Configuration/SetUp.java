package Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SetUp {
    protected static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    protected static final String RESET = "\033[0m";
    protected static WebDriver driver;

    @Parameters("browser")
    @BeforeClass

    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);


        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
           /* FirefoxOptions options = new FirefoxOptions();   //For headless browser
            options.addArguments("--headless");                 //
            options.addArguments("windows-size=1366,768");*/

        }
        driver.get("https://phoenix_epod_app.dice205.asia/"); 
        driver.getWindowHandle();
        driver.manage().window().maximize();

    }


}




