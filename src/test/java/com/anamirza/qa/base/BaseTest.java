package com.anamirza.qa.base;

import com.anamirza.qa.config.ConfigReader;
import com.anamirza.qa.drivers.DriverFactory;
import com.anamirza.qa.utils.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * BaseTest — parent class for all test classes.
 * Responsibilities:
 * - Initialize WebDriver before each test
 * - Navigate to base URL before each test
 * - Take screenshot if test fails
 * - Quit WebDriver after each test (always)
 */
public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverFactory.initDriver();// Initialize browser using config.properties settings
        driver = DriverFactory.getDriver();// Get the driver instance for this thread
        driver.get(ConfigReader.getUrl());  // Navigate to base URL
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        try {
            // Take screenshot only if test FAILED
            if (ITestResult.FAILURE == result.getStatus()) {
                String testName = result.getName();
                String screenshotPath = ScreenshotUtil.takeScreenshot(testName);
                System.out.println("Screenshot saved: " + screenshotPath);
            }
        } finally {
            // ALWAYS quit the browser — even if screenshot fails
            DriverFactory.quitDriver();
        }
    }
}