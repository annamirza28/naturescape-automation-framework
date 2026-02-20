package com.anamirza.qa.utils;

import com.anamirza.qa.config.ConfigReader;
import com.anamirza.qa.drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Utility class for explicit waits
 */
public class WaitUtil {
    private static WebDriverWait getWait() {

        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(ConfigReader.getTimeout())
        );
    }

    // Wait until element is visible
    public static WebElement waitForVisibility(By locator) {
        return getWait()
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait until element is clickable
    public static WebElement waitForClickable(By locator) {
        return getWait()
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait until element disappears
    public static void waitForInvisibility(By locator) {
        getWait()
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait until page title contains text
    public static void waitForTitleContains(String title) {
        getWait()
                .until(ExpectedConditions.titleContains(title));
    }
}
