package Test;

import BaseTest.BaseTest;
import Pages.ListingPage;
import Pages.LoginPage;
import org.testng.annotations.Listeners;
import Listeners.TestListener;
import org.testng.annotations.Test;

@Listeners(TestListener.class)

public class ListingTest extends BaseTest {
    public ListingPage listingPage;
    public LoginPage loginPage;
    @Test
    public void IsItemMetadataDisplayed(){
        loginPage = new LoginPage(driver);
        listingPage=new ListingPage(driver);
        loginPage.EnterUserName("standard_user");
        loginPage.EnterPassword("secret_sauce");
        loginPage.ClickLoginButton();
        listingPage.IsPriceDisplayed();
        listingPage.IsItemNameDisplayed();
        listingPage.IsMetaDataDisplayed();
    }
}
