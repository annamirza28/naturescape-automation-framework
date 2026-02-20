package com.anamirza.qa.utils;

import com.anamirza.qa.drivers.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Utility class for JavaScript actions
 */

public class JavaScriptUtil {
    // Get JS executor
    private static JavascriptExecutor getJs() {
        return (JavascriptExecutor) DriverFactory.getDriver();
    }

    // Click using JavaScript
    public static void click(WebElement element) {
        getJs().executeScript("arguments[0].click();", element);
    }

    // Scroll to element
    public static void scrollToElement(WebElement element) {
        getJs().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll to bottom
    public static void scrollToBottom() {
        getJs().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // Highlight element (for debugging)
    public static void highlight(WebElement element) {
        getJs().executeScript(
                "arguments[0].style.border='3px solid red'", element);
    }

    // Get page title using JS
    public static String getTitleByJS() {
        return getJs().executeScript("return document.title;").toString();
    }
}
