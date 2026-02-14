package Utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonUtils {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public Actions action;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action=new Actions(driver);
    }
    public void WaitUntilElementDisplayed(WebElement element){
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Error in displaying in element" + e.getMessage());
        }
    }
    public void WaitForClickable(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (NoSuchElementException|TimeoutException e){
            System.out.println("Error in clicking in element" + e.getMessage());
        }
    }
    public void ScrollTillElement(WebElement element) throws Exception {
        try{
            action.moveToElement(element).perform();
        }catch (NoSuchElementException e){
            throw new Exception(e.getMessage());
        }
    }
    public void WaitForExpectedUrl(String url){
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public Double StringToIntConversion(String s){
        char[] arr=s.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        for (char c : arr) {
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
            }
        }
        return Double.parseDouble(String.valueOf(stringBuilder));
    }
}
