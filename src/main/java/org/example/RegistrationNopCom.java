package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class RegistrationNopCom {
    protected static WebDriver driver;
    public static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    public static String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    public  static void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }
    public static long timeStamp(){
        Timestamp timestamp= new Timestamp(System.currentTimeMillis());
        return timestamp.getTime();
    }
    static String expectedRegistrationCompleteMsg = "Thanks for Registration";

    @BeforeMethod
    public static void openBrowser(){
        driver = new ChromeDriver();

        //open demonopcommerce url
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @AfterMethod
    public static void closeBrowser(){
        driver.close();
    }


    @Test
    public static void verifyUserShouldBeAbleToRegisterSuccessfully(){


        //click on register button
        clickOnElements(By.className("ico-register"));

        //enter first name
        typeText(By.id("FirstName"), "testFirstName");

        //enter last name
        typeText(By.id("LastName"),"testLatName");

        //enter email id
        typeText(By.name("Email"),"Testpatel"+timeStamp()+"@gmail.com");

        //enter password
        //driver.findElement(By.id("Password")).sendKeys("Test123");
        typeText(By.id("Password"),"Test123");

        //enter and confirm password
        // driver.findElement(By.id("ConfirmPassword")).sendKeys("Test123");
        typeText(By.id("ConfirmPassword"),"Test123");

        //click on register button
        // driver.findElement(By.id("register-button")).click();
        clickOnElements(By.id("register-button"));

        //verify message
        String actualmessage = getTextFromElement(By.xpath("//div[@class='result']"));
        getTextFromElement((By.xpath("//div[@class='result']")));

        //to print message
        System.out.println("message: " +actualmessage);
        Assert.assertEquals(actualmessage,expectedRegistrationCompleteMsg,"Registration not working");



    }
}







