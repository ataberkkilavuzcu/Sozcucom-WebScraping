package ataberkkilavuzcu;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());

        driver.findElement(By.className("gLFyf")).sendKeys("youtube");
        driver.findElement(By.className("gLFyf")).sendKeys(Keys.ENTER);
        // driver.quit();


    }
}
