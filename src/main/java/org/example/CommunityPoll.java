package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommunityPoll {
    protected static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //to open url
        driver.get("https://demo.nopcommerce.com/");
        //click on good text option
        driver.findElement(By.id("pollanswers-2")).click();
        //click on VOTE button
        driver.findElement(By.id("vote-poll-1")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("poll-vote-error")));

        //to verify message pop uo when u click on vote button
        String actualmessage = driver.findElement(By.className("poll-vote-error")).getText();
        //to print error messase
        System.out.println("my message: " +actualmessage);

        //for close browser
        driver.close();







    }

}
