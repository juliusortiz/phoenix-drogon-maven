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
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginIRT extends SetUp {


    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WebElements.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath(String.valueOf(sheet.getRow(1).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(4).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(6).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(6).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(7).getCell(0)))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login IRT = PASSED" + RESET);
        System.out.println();
        Thread.sleep(3000);
       /* WebElement Header = driver.findElement(By.xpath(String.valueOf(sheet.getRow(2).getCell(4))));
        Assert.assertTrue(Header.isDisplayed());
        System.out.println("Login Customer = PASSED");
        driver.quit();*/
    }

    @Test(priority = 1)
    public void InTransitOrdersPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click(); //in transit orders tab
        WebElement intransitorderspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")); //
        Assert.assertTrue(intransitorderspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to In-Transit Orders Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void AcceptedOrdersPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")).click(); //accepted orders tab
        WebElement acceptedorderspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")); //
        Assert.assertTrue(acceptedorderspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Accepted Orders Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void ImageSubmittedPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")).click(); //image submitted page
        WebElement imagesubmittedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")); //
        Assert.assertTrue(imagesubmittedpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Image Submitted Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 4)
    public void SettingsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/a/p")).click(); //settings page
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/a/p")); //
        Assert.assertTrue(settingspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Settings Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void NotificationPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
        driver.quit();
    }
}








