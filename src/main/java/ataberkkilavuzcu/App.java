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

        SozcuHomePage sozcuHomePage = new SozcuHomePage(driver);


        //  driver.quit();
        //https://www.softwaretestinghelp.com/selenium-webdriver-commands-selenium-tutorial-17/


    }
}
