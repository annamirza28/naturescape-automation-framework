package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Naturescape About Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/">About Page</a>
 * Verifies:
 * - Page heading is displayed with correct text
 * - Page title is correct
 * - Page refresh works correctly
 */
public class AboutPage {
    private final WebDriver driver;
    private final WindowManager windowManager;
    private final By heading = By.xpath("//h1[contains(.,'Commitments')]");
    // ========== Constructor ==========
    public AboutPage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    // ========== Page Validation ==========
    /**
     * Returns the current page URL.
     */
    public String getAboutPageURL() {
        return driver.getCurrentUrl();
    }
    /**
     * Returns the page title using JavaScript.
     * Example: "About | Naturescape® Lawn and Landscape Care"
     */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /**
     * Returns the H1 heading text.
     * Expected: "Naturescape®'s Commitments To You"
     */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(heading).getText().trim();
    }
    /**
     * Checks if the H1 heading is displayed on the page.
     */
    public boolean isHeadingDisplayed() {
        return WaitUtil.waitForVisibility(heading).isDisplayed();
    }
    // ========== Actions ==========
    /**
     * Refreshes the About page.
     * Used to verify the page reloads correctly.
     */
    public void refreshPage(){
        windowManager.refreshPage();
    }
    /**
     * Navigates back to the previous page (Home page).
     * Used to verify browser back navigation works.
     */
    public void goBack(){
        windowManager.goBack();
    }
}