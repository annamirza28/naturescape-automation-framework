package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object for the Naturescape Locations Page.
 * URL: <a href="https://naturescapelawncare.com/locations/">Locations Page</a>
 * Shows all 40 Naturescape branch locations across the midwest and south.
 */
public class NaturescapeLocationsPage {

    private final WebDriver driver;
    private final WindowManager windowManager;

    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[contains(.,'Naturescape') " +
                    "and contains(.,'Locations')]");
    private final By termsAndPrivacyLink =
            By.linkText("Terms & Privacy");
    private final By georgiaHeading = By.id("startGA");
    private final By indianaHeading = By.id("startIN");
    private final By illinoisHeading = By.id("startIL");
    private final By wisconsinHeading = By.id("startWI");

    // ========== Constructor ==========

    public NaturescapeLocationsPage(WebDriver driver) {
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

    /** Checks if the Locations page is loaded by checking the heading. */
    public boolean isLocationsPageLoaded() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }

    /** Returns the page heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }

    // ========== State Section Validation ==========

    /** Checks if Georgia section is displayed. */
    public boolean isGeorgiaSectionDisplayed() {
        return WaitUtil.waitForVisibility(georgiaHeading).isDisplayed();
    }

    /** Checks if Indiana section is displayed. */
    public boolean isIndianaSectionDisplayed() {
        return WaitUtil.waitForVisibility(indianaHeading).isDisplayed();
    }

    /** Checks if Illinois section is displayed. */
    public boolean isIlloisSectionDisplayed() {
        return WaitUtil.waitForVisibility(illinoisHeading).isDisplayed();
    }

    /** Checks if Wisconsin section is displayed. */
    public boolean isWisconsinSectionDisplayed() {
        return WaitUtil.waitForVisibility(wisconsinHeading).isDisplayed();
    }

    // ========== Actions ==========

    /**
     * Scrolls to the Terms and Privacy link at the bottom of the page.
     */
    public void scrollToTermsAndPrivacy() {
        WebElement element =
                WaitUtil.waitForVisibility(termsAndPrivacyLink);
        JavaScriptUtil.scrollToElement(element);
    }

    /** Navigates back to the previous page. */
    public void goBack() {
        windowManager.goBack();
    }

    /** Refreshes the page. */
    public void refreshPage() {
        windowManager.refreshPage();
    }
}