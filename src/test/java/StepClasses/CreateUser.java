package StepClasses;

import Base.BaseUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CreateUser extends BaseUtil {
    @Given("^logged in as Admin user$")
    public void loggedInAsAdminUser()  throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream(getClass().getClassLoader().getResource("Config.properties").getFile());
        Properties prop = new Properties();
        prop.load(fis);

        Select businesstype = new Select(driver.findElement(By.xpath("//select[@name='businesstype']")));
        businesstype.selectByVisibleText(String.valueOf("Phoenix Petroleum"));

        driver.findElement(By.xpath("//input[@name='username']"))
                .sendKeys(prop.getProperty("sa.username"));
        driver.findElement(By.xpath("//input[@name='pass']"))
                .sendKeys(prop.getProperty("password"));
        driver.findElement(By.xpath("//button[@class='login100-form-btn']")).click();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
       Thread.sleep(5000);
    }

    @And("^navigate to Manage users page$")
    public void navigateToManageUsersPage() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/header/button[1]/span")).click(); //dashboard button
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/aside[1]/div[1]/nav[1]/a[2]/div[1]")).click(); //manage user page
        WebElement ManageUserheader = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/main[1]/div[1]"));
        Assert.assertTrue(ManageUserheader.isDisplayed());
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @And("^navigate to Create user page from Manage Users$")
    public void navigateToCreateUserPageFromManageUsers() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button")).click(); //create user page
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        WebElement CreateUserpage = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/header/button"));
        Assert.assertTrue(CreateUserpage.isDisplayed());
    }

    @And("^create a dispatcher user from create user page$")
    public void createADispatcherUserFromCreateUserPage() throws InterruptedException {
        driver.findElement(By.id("username"))
                .sendKeys("lesterjohnjimenez");
        driver.findElement(By.id("email"))
                .sendKeys("lester.qaintern@dice205.com");
        driver.findElement(By.id("first_name"))
                .sendKeys("Lester John");
        driver.findElement(By.id("last_name"))
                .sendKeys("Jimenez");
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[1]/div[5]/div/div/div[1]/div/div[2]")).click(); //role
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[1]/div[5]/div/div/div[2]/div/div[4]")).click(); //role
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div/form/div[2]/button")).click(); //create
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }

    @Then("^admin logout page$")
    public void adminLogoutPage() throws InterruptedException {
            driver.findElement(By.xpath("/html/body/div[2]/main/header/button[2]/img")).click(); //logout page
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            WebElement logoutpage = driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")); //
            Assert.assertTrue(logoutpage.isDisplayed());

            driver.findElement(By.xpath("/html/body/div[2]/main/header/article/footer/section[2]")).click();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        }
    }

