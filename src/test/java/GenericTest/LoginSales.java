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
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Credentials.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(String.valueOf(sheet.getRow(5).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login Sales = PASSED" + RESET);
        System.out.println();
    }

    //lester
    @Test(priority = 1)
    public void FilterDropdown() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")).click(); //ser client
        WebElement filterdropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")); //ser client
        Assert.assertTrue(filterdropdown.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Filter Dropdown = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")).click(); //ser client
        Thread.sleep(3000);
    }

    // Thread.sleep(1000);
    @Test(priority = 2)
    public void TodayDropdown() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]")).click();
        WebElement todaydropdown = driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]")); //today dropdown
        Assert.assertTrue(todaydropdown.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Today Dropdown = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[3]/div/div[1]/div/div[2]")).click(); //today dropdown
        Thread.sleep(3000);
    }

   /* @Test(priority = 4)
    public void OnGoingDeliveries() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click(); //ongodeliveries
        WebElement ongoingdeliveries = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")); //ongodeliveries
        Assert.assertTrue(ongoingdeliveries.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to On Going Deliveries page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div/div/div/div[2]/div")).click(); //servicing client
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void DeliveryStatus() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")).click();
        WebElement deliverystatus = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[3]/div/div")); //deliverystatus
        Assert.assertTrue(deliverystatus.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery Status page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div/div[2]/div")).click(); //servicing client
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[2]/div/div/div[2]/div")).click(); //all
        Thread.sleep(2000);
    }*/

    @Test(priority = 3)
    public void History() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")).click();
        WebElement history = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div")); //history
        Assert.assertTrue(history.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to History page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")).click(); //filter
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/header/section/div[1]/div/div[1]/div[2]")).click(); //filter
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void ViewDetailsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/main/table/tbody/tr[1]/td[6]/a")).click(); //view details
        WebElement viewdetailspage = driver.findElement(By.xpath("/html/body/div[2]/main/section/div")); //
        Assert.assertTrue(viewdetailspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to View Details page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(3000);
        driver.findElement(By.xpath(" /html/body/div[2]/main/section/div/header/button")).click(); //back
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void SettingsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/a/span")).click(); //settings page
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
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]/span")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void LogoutPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //logout page
        Thread.sleep(2000);
        WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")); //
        Assert.assertTrue(logoutpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Logout Page = PASSED" + RESET);
        System.out.println();

        driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
        Thread.sleep(1000);
        driver.quit();
    }
}









