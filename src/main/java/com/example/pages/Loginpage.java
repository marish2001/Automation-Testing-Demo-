package com.example.pages;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Loginpage
{
    public static void main (String args[]) throws InterruptedException
    {
          ChromeOptions options = new ChromeOptions();
          options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
          Map<String, Object> prefs =new HashMap<>();
          prefs.put("credentials_enable_service",false);
          prefs.put("profile.password_manager_enabled",false);
          prefs.put("profile.password_manager_leak_detection", false);
          options.setExperimentalOption("prefs", prefs);


          WebDriver driver = new ChromeDriver(options);
          driver.manage().window().maximize();

          driver.get("https://www.saucedemo.com/");
          driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
          driver.findElement(By.id("password")).sendKeys("secret_sauce");
          driver.findElement(By.id("login-button")).click();

          String title = driver.findElement(By.className("title")).getText();
          if(title.equals("Products"))
          {
            System.out.print("\n Login Successful");
          }
          else 
          {
            System.out.print("\n Login Failed");
          }
          driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
          driver.findElement(By.className("shopping_cart_link")).click();
          String product = driver.findElement(By.className("inventory_item_name")).getText();
          System.out.print("\n Product in cart"+product);
          driver.findElement(By.id("checkout")).click();

          driver.findElement(By.id("first-name")).sendKeys("Marish");
          driver.findElement(By.id("last-name")).sendKeys("Muruganandam");
          driver.findElement(By.id("postal-code")).sendKeys("600030");
          driver.findElement(By.id("continue")).click();

          driver.findElement(By.id("finish")).click();

          String message = driver.findElement(By.className("complete-header")).getText();

          if(message.equals("Thank you for your order!"))
          {
            System.out.print("\n Your order has been successfully placed and will arrive just as fast as the pony can get there!");
          }
          else 
          {
            System.out.print("\n Order failed");
          }
          driver.findElement(By.id("generate-pdf-order")).click();
          driver.findElement(By.id("back-to-products")).click();
          Thread.sleep(1000);
          System.out.print("\n Logout Successfully");
          driver.quit();

    }
}
