package BasePage;

import Utils.CommonUtils;
import org.openqa.selenium.WebDriver;

public class BasePage extends CommonUtils {
    public WebDriver driver;
    public BasePage(WebDriver driver){
        super(driver);
    }

}
