package Pages;

import BasePage.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "user-name")
    public WebElement UserNameTextField;
    @FindBy(id = "password")
    public WebElement Password;
    @FindBy(id = "login-button")
    public WebElement LoginButton;
    @FindBy(xpath = "//div[@class=\"error-message-container error\"]")
    public WebElement ErrorMessage;
    public void EnterUserName(String UserName){
        WaitUntilElementDisplayed(UserNameTextField);
        UserNameTextField.sendKeys(UserName);
    }
    public void EnterPassword(String password){
        WaitUntilElementDisplayed(Password);
        Password.sendKeys(password);
    }
    public void ClickLoginButton(){
        WaitForClickable(LoginButton);
        LoginButton.click();
    }
    public void WaitUntilUrlChange(){
        WaitForExpectedUrl("https://www.saucedemo.com/inventory.html");
    }
    public boolean IsErrorMessageDisplayed(){
        try {
            WaitUntilElementDisplayed(ErrorMessage);
            return ErrorMessage.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
