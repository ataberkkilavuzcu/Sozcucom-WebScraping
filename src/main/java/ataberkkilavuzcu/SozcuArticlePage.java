package ataberkkilavuzcu;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SozcuArticlePage{

    private WebDriver driver;
    private By articleTitle = By.cssSelector("div.col-lg-8.content > article > h1");
    private By articleText = By.cssSelector("#author_load_area > div.col-lg-8.content > article > p");

    public SozcuArticlePage(WebDriver driver){
        this.driver = driver;
        SaveTextFile saveTextFile = new SaveTextFile(getTitle(),getText());
        
    }
    private String getTitle(){
        WebElement title = driver.findElement(articleTitle);
        return title.getText();
    }
    private String getText(){
        String text = "";
        List<WebElement> articleTexts = new ArrayList<WebElement>();
        articleTexts = driver.findElements(articleText);
        for(int i = 0; i < articleTexts.size(); i++){
            text += articleTexts.get(i).getText();
        }
        return text;

    }
    private void switchToNextPage(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }

}