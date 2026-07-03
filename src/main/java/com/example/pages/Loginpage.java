package com.example.pages;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Loginpage
{
    public static void main (String args[]) throws InterruptedException
    {
          ChromeOptions options = new ChromeOptions();
          options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

          WebDriver driver = new ChromeDriver(options);
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

          driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

          WebElement username = driver.findElement(By.name("username"));
          username.sendKeys("Admin");

          WebElement password = driver.findElement(By.name("password"));
          password.sendKeys("admin123");

          WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
          loginButton.click();
 
          WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
          if(dashboard.isDisplayed())
          {
            System.out.print("\n Successfully Logined");
          }
          else 
          {
            System.out.print("\n Invalid login");
          }
          System.out.println("URL of the website"+driver.getCurrentUrl());
          System.out.println("Page Title"+driver.getTitle());
          System.out.println("Brwoser Launched");
          driver.quit();

    }
}