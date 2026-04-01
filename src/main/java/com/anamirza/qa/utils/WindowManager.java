package com.anamirza.qa.utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;
/**
 * Utility class for browser window and tab management.
 * Wraps Selenium's navigation and window-switching APIs
 * into clean, readable methods.
 * Instance-based — requires a WebDriver passed in constructor.
 * Used by page objects that need to handle multi-tab navigation.
 */

public class WindowManager {
    private final WebDriver driver;
    /**
     * Creates a WindowManager for the given WebDriver instance.
     * @param driver the active WebDriver session
     */
    public WindowManager(WebDriver driver) {
        this.driver = driver;
    }

    //Navigation
    /**
     * Navigates back to the previous page in browser history.
     * Equivalent to clicking the browser Back button.
     */
    public void goBack() {
        driver.navigate().back();
    }
    /**
     * Navigates forward in browser history.
     * Equivalent to clicking the browser Forward button.
     */
    public void goForward() {
        driver.navigate().forward();
    }
    /**
     * Refreshes the current page.
     * Equivalent to pressing F5 in the browser.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }
    /**
     * Navigates to the given URL.
     * @param url the full URL to navigate to
     */
    public void goTo(String url) {
        driver.navigate().to(url);
    }

    // Switch to tab by title
    /**
     * Switches to the tab whose title exactly matches the given text.
     * Iterates through all open windows until a match is found.
     * @param tabTitle exact title of the tab to switch to
     * @throws RuntimeException if no tab with that title is found
     */
    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(tabTitle)) {
                return;
            }
        }
        throw new RuntimeException("Tab with title '" + tabTitle + "' not found.");
    }
    /**
     * Switches to the newly opened tab/window.
     * Finds the window handle that is different from the original.
     * @param originalWindow handle of the window before the new tab opened
     * @throws RuntimeException if no new tab is found
     */
    public void switchToNewTab(String originalWindow) {
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                return;
            }
        }
        throw new RuntimeException("New tab not found.");
    }

}

