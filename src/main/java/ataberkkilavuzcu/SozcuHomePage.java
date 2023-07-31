package ataberkkilavuzcu;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.chrome.ChromeDriver;

public class SozcuHomePage{

    private WebDriver driver;
    private By searchButton = By.cssSelector("a.search-button");
    private final String url = "https://www.sozcu.com.tr/";

    public SozcuHomePage(WebDriver driver){
        this.driver = driver;
        driver.get(url);
        clickSearchButton();
        switchToNextPage();
        SozcuSearchPage sozcuSearchPage = new SozcuSearchPage(driver, "Ege Cansen");
    }
        private void switchToNextPage(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }


}