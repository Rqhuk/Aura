package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;
    public ChromeOptions options;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        options=new ChromeOptions();
        driver = new ChromeDriver();
        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) " +
                "Chrome/125.0.0.0 Safari/537.36");
        driver.manage().window().maximize();   // optional but recommended
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();   // closes all tabs + ends session
        }
    }
}
