package GenericTest;
import org.openqa.selenium.By;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import Configuration.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.thread.IThreadWorkerFactory;


public class LoginSales extends SetUp {

    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WebElements.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath(String.valueOf(sheet.getRow(1).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(5).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(6).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(6).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(7).getCell(0)))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login Sales = PASSED" + RESET);
        System.out.println();

        //lester


        WebElement servingclient = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div")); //ser client
        Assert.assertTrue(servingclient.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Serving Client = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        WebElement last6months =  driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[2]/div/div[2]/div")).click(); //last 6 months
        Assert.assertTrue(last6months.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + " = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        /* driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[2]/div/div[2]/div")).click(); //last 6 months
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/main/table/tbody/tr[1]/td[7]/a")).click(); //view dr
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click(); //ongodeliveries
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")).click(); //deliverystatus
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")).click(); //history
        Thread.sleep(1000);
*/
        driver.quit();
    }
}









