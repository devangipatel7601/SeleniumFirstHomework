package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConfirmProductNameInShoppingCart {
    protected static WebDriver driver;

    public static void main(String[] args) {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

        //click on electronics
        driver.findElement(By.xpath("//div[@class='master-wrapper-page']/div[2]/ul/li[2]/a[@href='/electronics']")).click();
        //click on Camera & photo text
       driver.findElement(By.xpath("//img[@alt='Picture for category Camera & photo']")).click();

        //click on Leica T Mirrorless Digital Camera
       driver.findElement(By.linkText("Leica T Mirrorless Digital Camera")).click();
       //get product name
       // String productname = driver.findElement(By.linkText("Leica T Mirrorless Digital Camera")).getText();
        //System.out.println("Print product name: " +productname);
       // click on ADD TO CART button
        driver.findElement(By.xpath("//div[@class=\"add-to-cart\"]/div/button")).click();
        //close green bar
      //  driver.findElement(By.xpath("//span[@class=\"close\"]"));

        //click on shopping cart on right top corner of page
        driver.findElement(By.xpath("//span[@class=\"cart-label\"]"));

        //verify & print out leica camera name text
       String productname1 = driver.findElement(By.className("product-name")).getText();

       System.out.println("Product in cart: "+ productname1);

        //confirm product name is same in shopping cart as what we add




    }

}
