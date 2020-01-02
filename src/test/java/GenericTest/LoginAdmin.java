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


public class LoginAdmin extends SetUp {


    @Test(priority = 0)
    public void Login() throws InterruptedException, IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("WebElements.xlsx");
        assert inputStream != null;
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Select businesstype = new Select(driver.findElement(By.xpath(String.valueOf(sheet.getRow(0).getCell(0)))));
        businesstype.selectByVisibleText(String.valueOf(sheet.getRow(0).getCell(1)));

        driver.findElement(By.xpath(String.valueOf(sheet.getRow(1).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(1).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(6).getCell(0))))
                .sendKeys(String.valueOf(sheet.getRow(6).getCell(1)));
        driver.findElement(By.xpath(String.valueOf(sheet.getRow(7).getCell(0)))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement dashboardchart = driver.findElement(By.cssSelector(String.valueOf(sheet.getRow(1).getCell(5))));
        Assert.assertTrue(dashboardchart.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Login Admin = PASSED" + RESET);
        System.out.println();
    }

    @Test(priority = 1)
    public void NavigateToManageAdmin() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click();
        WebElement ManageAdminheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageAdminheader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Admins page = PASSED" + RESET);
        System.out.println();
    }


    @Test(priority = 2)
    public void NavigateToManageStatuses() throws InterruptedException, IOException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[3]/div[1]/div[1]")).click(); //status
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement ManageStatusHeader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]/header[1]/span[1]"));
        Assert.assertTrue(ManageStatusHeader.isDisplayed());
        System.out.print(CYAN_BOLD_BRIGHT + "Navigation to Manage Status page = PASSED" + RESET);
        System.out.println();
    }
}












