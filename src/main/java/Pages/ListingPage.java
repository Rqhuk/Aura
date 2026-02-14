package Pages;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListingPage extends BasePage {
    public ListingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[local-name()='img' and @alt='Sauce Labs Backpack']/ancestor::div[@class=\"inventory_item\"]//div[@class=\"inventory_item_price\"]")
    private WebElement Price;
    @FindBy(xpath = "//*[local-name()='img' and @alt='Sauce Labs Backpack']/ancestor::div[@class=\"inventory_item\"]//div[@class=\"inventory_item_desc\"]")
    private WebElement MetaData;
    @FindBy(xpath = "//*[local-name()='img' and @alt='Sauce Labs Backpack']/ancestor::div[@class=\"inventory_item\"]//div[@class=\"inventory_item_name \"]")
    private WebElement ItemName;

    public boolean IsPriceDisplayed() {
        try {
            WaitUntilElementDisplayed(Price);
            return Price.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsMetaDataDisplayed(){
        try{
            WaitUntilElementDisplayed(MetaData);
            return MetaData.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public boolean IsItemNameDisplayed(){
        try {
            WaitUntilElementDisplayed(ItemName);
            return ItemName.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
