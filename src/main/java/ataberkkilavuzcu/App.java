package ataberkkilavuzcu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class App 
{
    public static void main( String[] args )
    {
         WebDriver driver = new ChromeDriver();
         SozcuHomePage sozcuHomePage = new SozcuHomePage(driver);
         driver.quit();

    }
}
