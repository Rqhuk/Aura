package BasePage;

import Utils.ElementUtils;
import org.openqa.selenium.WebDriver;

public class BasePage extends ElementUtils {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        super(driver);
    }

}
