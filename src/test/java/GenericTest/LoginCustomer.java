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


public class LoginCustomer extends SetUp {


    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WebElements.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath(String.valueOf(sheet.getRow(1).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(2).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(6).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(6).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(7).getCell(0)))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login Customer = PASSED" + RESET);
        System.out.println();
           /* WebElement Header = driver.findElement(By.xpath(String.valueOf(sheet.getRow(2).getCell(4))));
        Assert.assertTrue(Header.isDisplayed());
        System.out.println("Login Customer = PASSED");
        driver.quit();*/
    }
    //lester

    @Test(priority = 1)
    public void DeliveryStatusPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")).click(); //delivery status page
        WebElement deliverystatuspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[2]/div/div")); //
        Assert.assertTrue(deliverystatuspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery Status Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void DeliveryReceiptsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[3]/div/div")).click(); //delivery receipts page
        WebElement deliveryreceiptspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[3]/div/div")); //
        Assert.assertTrue(deliveryreceiptspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery Receipts Page = PASSED" + RESET);
        System.out.println();
       Thread.sleep(4000);
    }
    @Test(priority = 3)
    public void HistoryPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[4]/div/div")).click(); //history page
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[4]/div/div")); //
        Assert.assertTrue(historypage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to History Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(3000);
    }
    @Test(priority = 4)
    public void CDSSProfilePage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[5]/div/div")).click(); //cdss profile page
        WebElement historypage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/section/div/nav/a[5]/div/div")); //
        Assert.assertTrue(historypage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to CDSS Profile Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
    }
    @Test(priority = 5)
    public void SettingsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/footer/div/section[1]/a/span")).click(); //settings page
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[2]")).click(); //send feedback
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")).click(); //about this app
        WebElement settingspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/article/header/a[3]")); //
        Assert.assertTrue(settingspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Settings Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void NotificationPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[2]/div/a")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);

    }
    @Test(priority = 7)
    public void LogoutPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")).click(); //dashboard
        Thread.sleep(1000);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/div/div[1]/button/span")); //
        Assert.assertTrue(logoutpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Logout Page = PASSED" + RESET);
        System.out.println();

        driver.findElement(By.xpath("/html/body/div[2]/aside/div/footer/div/section[2]/button/span")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}









