package GenericTest;
import org.openqa.selenium.By;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Configuration.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginScheduler extends SetUp {

    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WebElements.xlsx");
    assert inputStream != null;
    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
    XSSFSheet sheet = workbook.getSheetAt(0);
    Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
    businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(String.valueOf(sheet.getRow(6).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(7).getCell(0)))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();
}
}

