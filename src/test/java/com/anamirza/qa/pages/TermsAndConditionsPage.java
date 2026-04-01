package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape Terms and Conditions Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/survey-terms/">Terms Page</a>
 * Opens in a new tab from the Customer Service Response page.
 */
public class TermsAndConditionsPage {
    private final WebDriver driver;
    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[contains(.,'Terms and Conditions')]");
    // ========== Constructor ==========

    public TermsAndConditionsPage(WebDriver driver) {
        this.driver = driver;
    }
    // ========== Page Validation ==========
    /**
     * Returns the current page URL.
     */
    public String getPageURL(){
        return driver.getCurrentUrl();
    }
    /**
     * Verifies the Terms and Conditions page loaded correctly.
     */
    public boolean isTermsPageLoaded(){
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /**
     * Returns the heading text
     */
    public String getHeadingText(){
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
}
