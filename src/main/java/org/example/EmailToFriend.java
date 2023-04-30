package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class EmailToFriend {
    protected static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demo.nopcommerce.com/");

        //click on add to cart button
        driver.findElement(By.xpath("//div[@class = \"item-grid\" ]/div[2]/div/div[2]/div[3]/div[2]/button[1]")).click();

        //click on email a friend
        driver.findElement(By.xpath("//div[@class='email-a-friend']")).click();
        //type friend's email
        driver.findElement(By.id("FriendEmail")).sendKeys("tpatel@gmail.com");
        //type your email id
        driver.findElement(By.id("YourEmailAddress")).sendKeys("Testpatel@gmail.com");
        //click on send email
        driver.findElement(By.name("send-email")).click();
        String actualmessage = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li")).getText();

        System.out.println("Error message: " +actualmessage);
        driver.close();
    }
}
