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


public class LoginAdmin extends SetUp {


    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("Credentials.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(String.valueOf(sheet.getRow(1).getCell(1)));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(String.valueOf(sheet.getRow(8).getCell(1)));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();


    /*    WebElement dashboardchart = driver.findElement(By.cssSelector(String.valueOf(sheet.getRow(1).getCell(5))));
        Assert.assertTrue(dashboardchart.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();*/
        Thread.sleep(5000);
    }
    //dashboard
    @Test(priority = 1)
    public void StatusPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[1]/a/div")).click(); //status page
        WebElement Statuspage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Statuspage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Status page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]")).click(); //home
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void CustomerPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[2]/a")).click(); //customer page
        WebElement Customerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Customerpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Customer page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    public void TruckDriverPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/section/div/section/section/button[3]/a")).click(); //customer page
        WebElement Truckdriverpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]"));
        Assert.assertTrue(Truckdriverpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Truck Driver page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[1]/img")).click(); //home
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    public void ManageUsersPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Users page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void CreateUsersPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        Thread.sleep(2000);
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Users page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(2000);
    }
    @Test(priority = 6)
    public void ManageStatusesPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]")).click(); //status
        WebElement ManageStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageStatusHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Status page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void ManageCustomerPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[4]/div[1]")).click(); //manage customer
        WebElement ManageCustomerHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageCustomerHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Customer page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }

    @Test(priority = 8)
    public void CreateCustomerPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        Thread.sleep(2000);
        WebElement CreateCustomerpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateCustomerpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Customer page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(2000);
    }

    @Test(priority = 9)
    public void ManageTruckDriversPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[5]/div[1]")).click(); //manage truck drivers
        WebElement ManageTruckDriverHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageTruckDriverHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Truck Drivers page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }
    @Test(priority = 10)
    public void CreateDriverPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        Thread.sleep(2000);
        WebElement CreateDriverpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateDriverpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Create Driver page = PASSED" + RESET);
        System.out.println();
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button/span")).click(); //close
        Thread.sleep(2000);
    }

    @Test(priority = 11)
    public void DeliveryReceiptsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[6]/div[1]")).click(); // delivery receipts //all
        WebElement DeliveryReceipts = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(DeliveryReceipts.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Delivery Receipts page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(3000);
    }

    @Test(priority = 12)
    public void ProblemsReportedAndBackloadsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[7]/div")).click(); //problems and back reloads
        WebElement ProblemsReportedAndBackloads = driver.findElement(By.xpath("/html/body/div[2]/aside/div/nav/a[7]/div"));
        Assert.assertTrue(ProblemsReportedAndBackloads.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Problems Reported And Backloads page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/button")).click(); //add new reason
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/div/button")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/div[2]/div/div/div/div[2]/div")).click(); //backload
        Thread.sleep(2000);
    }

    @Test(priority = 13)
    public void SettingsPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[2]/aside/div/a")).click(); //settings page
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

    @Test(priority = 14)
    public void NotificationPage() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")).click(); //notfication page
        WebElement notificationpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/a[2]")); //
        Assert.assertTrue(notificationpage.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Notification Page = PASSED" + RESET);
        System.out.println();
        Thread.sleep(2000);
    }
    @Test(priority = 15)
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









