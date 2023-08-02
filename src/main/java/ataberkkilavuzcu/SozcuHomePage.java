package ataberkkilavuzcu;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SozcuHomePage{

    private WebDriver driver;
    private By searchButton = By.cssSelector("a.search-button");
    private final String url = "https://www.sozcu.com.tr/";

    public SozcuHomePage(WebDriver driver){
        UserJDatePicker userJDatePicker =  new UserJDatePicker();
        int date = userJDatePicker.getDay();
        int month = userJDatePicker.getMonth();
        int year = userJDatePicker.getYear();
        this.driver = driver;
        driver.get(url);
        clickSearchButton();
        switchToNextPage();
        SozcuSearchPage sozcuSearchPage = new SozcuSearchPage(driver, "Ege Cansen");
        SozcuAuthorPage sozcuAuthorPage = new SozcuAuthorPage(driver,date,month,year);
    }
        private void switchToNextPage(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }


}