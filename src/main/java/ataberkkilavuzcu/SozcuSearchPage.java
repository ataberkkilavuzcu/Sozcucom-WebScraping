package ataberkkilavuzcu;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SozcuSearchPage {
    private WebDriver driver;
    private By searchBox = By.cssSelector("input[id='gsc-i-id1']");
    private By authorPage = By.xpath("//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a");

    public SozcuSearchPage(WebDriver driver, String searchString) {
        this.driver = driver;
        search(searchString);
        switchToNextPage();
        clickToAuthorsPage();
        }

    private void search(String authorName) {
        WebElement textBox = driver.findElement(searchBox);
        textBox.sendKeys(authorName);
        textBox.sendKeys(Keys.ENTER);
    }

    private void switchToNextPage(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    private void clickToAuthorsPage(){
        driver.findElement(authorPage).click();
    }


}
