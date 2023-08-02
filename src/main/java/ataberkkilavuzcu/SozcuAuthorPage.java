package ataberkkilavuzcu;

import java.text.DateFormatSymbols;
import java.util.*;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SozcuAuthorPage {

    private WebDriver driver;
    private By monthForm = By.cssSelector("select#month");
    private By yearForm = By.cssSelector("select#queryyear");
    private By filterButton = By.cssSelector("#yazararsiv > button");
    private By articleYears = By.cssSelector("span.date");
    private WebElement dateToClick;
    UserJDatePicker userJDatePicker;
    
    public SozcuAuthorPage(WebDriver driver, int date, int month, int year){
        this.driver = driver;
        switchToNextPage();
        String monthString = getMonth(month);
        String yearString = String.valueOf(year);
        String dateString = String.valueOf(date);
        selectMonth(monthString);
        selectYear(yearString);
        WebElement filteringButton = driver.findElement(filterButton);
        // button is not visible so were scrolling down
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", filteringButton);
        if(articleFound(dateString, monthString, yearString)){
           executor.executeScript("arguments[0].click();", dateToClick);
           SozcuArticlePage sozcuArticlePage = new SozcuArticlePage(driver);
        }
        else{
            JOptionPane.showMessageDialog(null,"COULDNT FIND:/");
            System.exit(0);
        }
    }
    public boolean articleFound(String date, String month, String year){
        String fullYear = date+" "+month+" "+year;
        System.out.println("Fullyear: "+fullYear);
        List<WebElement> articleDates = new ArrayList<WebElement>();
        articleDates = driver.findElements(articleYears);
        int i = 0;
        while(i < articleDates.size()){
          // testing  System.out.println("ArticleDate "+i+" "+articleDates.get(i).getText());
            if(articleDates.get(i).getText().equalsIgnoreCase(fullYear)){
                dateToClick = articleDates.get(i);
                return true;
            }
            i++;
        }
        return false;
    }
    private void switchToNextPage(){
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));
    }
    public void selectMonth(String month){
        List<WebElement> monthList = driver.findElements(monthForm);
        Select selectMonth = new Select(monthList.get(0));
        selectMonth.selectByVisibleText(month);
    }
    public void selectYear(String year){
        List<WebElement> yearList = driver.findElements(yearForm);
        Select selectYear = new Select(yearList.get(0));
        selectYear.selectByVisibleText(year);
    }
    
    public String getMonth(int month) {
    return new DateFormatSymbols().getMonths()[month-1];
    }
    
    
}
