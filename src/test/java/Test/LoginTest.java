package Test;


import BaseTest.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import Listeners.TestListener;


@Listeners(TestListener.class)

public class LoginTest extends BaseTest {
    public LoginPage loginPage;

    @Test
    public void ValidLogin() {
        loginPage = new LoginPage(driver);
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.ClickLoginButton();
        loginPage.WaitUntilUrlChange();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
    @Test
    public void Negative(){

    }
}
