package Hooks;

import Base.BaseUtil;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseUtil {

    @Before
    public void InitializeTest() throws IOException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //   options.addArguments("--headless");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        driver.get(prop.getProperty("base.URL"));
        driver.getWindowHandle();
        driver.manage().window().maximize();
    }

    @After
    public void TearDownTest() {
        driver.quit();
    }
}
