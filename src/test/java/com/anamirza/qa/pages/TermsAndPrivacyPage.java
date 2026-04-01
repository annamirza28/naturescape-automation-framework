package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape Terms and Privacy Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/policies/">Terms and Privacy</a>
 * Accessible from the footer "Terms and Privacy" link on all pages.
 */

public class TermsAndPrivacyPage {
    private final WebDriver driver;
    private final WindowManager windowManager;
    private final By pageHeading = By.xpath("//h1[contains(.,'Terms of Use')]");

    public TermsAndPrivacyPage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    // ========== Page Validation ==========

    /** Returns the current page URL. */
    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }

    /** Checks if the Terms and Privacy page is loaded. */
    public boolean isPageLoaded() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /**
     * Alias for isPageLoaded().
     * Used by HomePageTests shouldNavigateToTermsAndPrivacyPage().
     */
    public boolean isTermsPageLoaded() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }

    /** Returns the heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }

    // ========== Actions ==========

    /** Navigates back to the previous page. */
    public void goBack() {
        windowManager.goBack();
    }

    /** Refreshes the page. */
    public void refreshPage() {
        windowManager.refreshPage();
    }
}

