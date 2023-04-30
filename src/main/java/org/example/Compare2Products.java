package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Compare2Products {
    protected static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

        //click on phone compare button
        driver.findElement(By.xpath("//div[@class='item-grid']/div[3]/div[1]/div[2]/div[3]/div[2]/button[2]")).click();

        driver.findElement(By.xpath("//span[@class= \"close\"]"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        //click on card compare button

        driver.findElement(By.xpath("//div[@class='item-grid']/div[4]/div[1]/div[2]/div[3]/div[2]/button[2]")).click();

        driver.findElement(By.xpath("//span[@class= \"close\"]"));
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"bar-notification success\"]/p/a[@href=\"/compareproducts\"]")));
       //click on green line
        driver.findElement(By.xpath("//div[@class=\"bar-notification success\"]/p/a[@href=\"/compareproducts\"]")).click();
        //printout mobile name
       String actualmessage = driver.findElement(By.xpath("//table[@class=\"compare-products-table\"]/tbody/tr[3]/td[2]/a")).getText();
        System.out.println("message: " + actualmessage);
        String actualmessage1 = driver.findElement(By.xpath("//table[@class=\"compare-products-table\"]/tbody/tr[3]/td[3]/a")).getText();
        System.out.println("message: " + actualmessage1);
        driver.findElement(By.className("clear-list")).click();
       String actualmessage2 = driver.findElement(By.className("no-data")).getText();
        System.out.println("message :" + actualmessage2);
        driver.close();

    }
}
