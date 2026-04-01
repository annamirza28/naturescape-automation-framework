package com.anamirza.qa.utils;

import com.anamirza.qa.config.ConfigReader;
import com.anamirza.qa.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * Utility class for explicit waits.
 * All waits use timeout configured in config.properties.
 * Eliminates flaky Thread.sleep() usage across the framework.
 */
public class WaitUtil {
    // Private constructor — utility class, should never be instantiated
    private WaitUtil() {}
    /**
     * Creates a WebDriverWait instance using the configured timeout.
     * Includes null guard — fails clearly if driver not initialized.
     */
    private static WebDriverWait getWait() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver is not initialized. " +
                            "Call DriverFactory.initDriver() first.");
        }
        return new WebDriverWait(driver,
                Duration.ofSeconds(ConfigReader.getTimeout()));
    }
    /**
     * Waits until element located by locator is visible on page.
     * Use when: element exists in DOM and you need to see it.
     */
    public static WebElement waitForVisibility(By locator) {
        return getWait()
                .until(ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }
    /**
     * Waits until element located by locator is visible AND enabled.
     * Use when: you are about to click something.
     */
    public static WebElement waitForClickable(By locator) {
        return getWait()
                .until(ExpectedConditions
                        .elementToBeClickable(locator));
    }
    /**
     * Waits until element is no longer visible on page.
     * Use when: waiting for a loader/spinner to disappear.
     */
    public static void waitForInvisibility(By locator) {
        getWait()
                .until(ExpectedConditions
                        .invisibilityOfElementLocated(locator));
    }
    /**
     * Waits until the page title contains the given text.
     * Use when: verifying navigation completed to correct page.
     */
    public static void waitForTitleContains(String title) {
        getWait()
                .until(ExpectedConditions.titleContains(title));
    }
    /**
     * Waits until the total number of open windows equals the given number.
     * Use when: waiting for a specific number of tabs to be open.
     */
    public static void waitForNumberOfWindowsToBe(int number) {
        getWait()
                .until(ExpectedConditions.numberOfWindowsToBe(number));
    }

    /**
     * Waits until a new tab/window opens beyond the current count.
     * Use when: clicking a link that opens a new tab.
     * @param currentWindowCount number of windows BEFORE the click
     */
    public static void waitForNewWindowToOpen(int currentWindowCount) {
        getWait().until(driver ->
                driver.getWindowHandles().size() > currentWindowCount);
    }
}