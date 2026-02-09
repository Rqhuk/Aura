package Listeners;

import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();
        WebDriver driver = null;

        try {
            // Get driver from BaseTest using reflection
            Field driverField = result.getTestClass()
                    .getRealClass()
                    .getSuperclass()   // BaseTest
                    .getDeclaredField("driver");

            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testClass);

        } catch (Exception e) {
            System.out.println("❌ Could not fetch driver: " + e.getMessage());
        }

        if (driver != null) {
            takeScreenshot(driver, result.getName());
        } else {
            System.out.println("❌ Driver is NULL - Screenshot not possible");
        }
    }

    private void takeScreenshot(WebDriver driver, String testName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String path = System.getProperty("user.dir")
                    + "/screenshots/" + testName + ".png";

            File dest = new File(path);
            dest.getParentFile().mkdirs();

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("📸 Screenshot saved: " + path);

        } catch (Exception e) {
            System.out.println("❌ Screenshot capture failed: " + e.getMessage());
        }
    }
}
