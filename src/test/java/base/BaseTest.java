package base;

import com.anamirza.qa.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;
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
    public void tearDown() {

        // Quit browser
        DriverFactory.quitDriver();
    }
}
