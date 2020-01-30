package StepClasses;
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


public class LoginDispatcher extends SetUp {


    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Credentials.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(String.valueOf(sheet.getRow(3).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println(CYAN_BOLD_BRIGHT + "Login Dispatcher = PASSED" + RESET);
        System.out.println();
       /* WebElement Header = driver.findElement(By.xpath(String.valueOf(sheet.getRow(2).getCell(4))));
        Assert.assertTrue(Header.isDisplayed());
        System.out.println("Login Customer = PASSED");
        driver.quit();*/
        Thread.sleep(4000);
    }

/*    @Test(priority = 1)
    public void DeliveryHistoryPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div")).click(); //delivery history page
        WebElement deliveryhistorypage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div")); //
        Assert.assertTrue(deliveryhistorypage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Delivery History Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/div/div[2]/div/article[1]/div/footer/a")).click(); //read more
        Thread.sleep(2000);
    }*/

        @Test(priority = 1)
        public void ProblemsReportedPage() throws InterruptedException, IOException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span")).click(); //problems reported page
            WebElement problemsreportedpage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[2]/div/div/span")); //
            Assert.assertTrue(problemsreportedpage.isDisplayed());
            System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Problems Reported Page = PASSED" + RESET);
            System.out.println();
            Thread.sleep(2000);
        }

     /*   @Test(priority = 3)
        public void ManageReasonsPage() throws InterruptedException, IOException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
            Thread.sleep(2000);
            driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")).click(); //manage reasons page
            WebElement managereasonspage = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[4]/div/div")); //
            Assert.assertTrue(managereasonspage.isDisplayed());
            System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Reasons Page = PASSED" + RESET);
            System.out.println();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div/div/div/div[2]/div")).click(); //backload
            Thread.sleep(2000);
        }*/

        @Test(priority = 2)
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

        @Test(priority = 3)
        public void NotificationPage() throws InterruptedException, IOException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
            WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
            Assert.assertTrue(notificationpage.isDisplayed());
            System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
            System.out.println();
            Thread.sleep(2000);
        }

        @Test(priority = 4)
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








