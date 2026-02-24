package base;

import com.anamirza.qa.drivers.DriverFactory;
import com.anamirza.qa.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Initialize driver using config.properties
        DriverFactory.initDriver();
        // Get current driver
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        // If test FAILED → take screenshot
        if (ITestResult.FAILURE == result.getStatus()) {
            String testName = result.getName();
            ScreenshotUtil.takeScreenshot(testName);
            System.out.println("Screenshot taken for failed test: " + testName);
        }
        // Quit browser
        DriverFactory.quitDriver();
    }
}
