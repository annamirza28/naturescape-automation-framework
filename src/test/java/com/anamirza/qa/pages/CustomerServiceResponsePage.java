package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape Customer Service Response Page.
 * URL: <a href="https://sg.naturescapelawncare.com/s3/Customer-Service-Response">Survey Page</a>
 * Opens from the "Customer Satisfaction Survey" button/link site-wide.
 */
public class CustomerServiceResponsePage {
    private final WebDriver driver;
    private final WindowManager windowManager;
    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[contains(.,'Customer Service Response')]");
    private final By surveySubheading =
            By.xpath("//h2[contains(.,'Survey')]");
    private final By propertyNumberField =
            By.xpath("//input[@title='What is your property number?']");
    private final By billingZipCodeField =
            By.xpath("//input[@title='What is your billing zip code?']");
    private final By emailField =
            By.xpath("//input[@title='What is your email address?']");
    private final By termsAndConditionsLink =
            By.linkText("Terms and Conditions");
    // ========== Constructor ==========
    public CustomerServiceResponsePage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    // ========== Page Validation ==========
    /** Returns the current page URL. */
    public String getSurveyPageURL() {
        return driver.getCurrentUrl();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /**Verifies the page is loaded by checking the main heading.*/
    public boolean isSurveyPageLoaded() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /**Returns the main heading text.*/
    public String getPageHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading)
                .getText().trim();
    }
    /**Returns the survey subheading text.*/
    public String getSurveySubheadingText() {
        return WaitUtil.waitForVisibility(surveySubheading)
                .getText().trim();
    }
    // ========== Form Field Validation ==========
    /**Checks if the property number field is displayed.*/
    public boolean isPropertyNumberFieldDisplayed() {
        return WaitUtil.waitForVisibility(propertyNumberField).isDisplayed();
    }
    /**Checks if the billing zip code field is displayed.*/
    public boolean isBillingZipCodeFieldDisplayed() {
        return WaitUtil.waitForVisibility(billingZipCodeField)
                .isDisplayed();
    }
    /**Checks if the email address field is displayed.*/
    public boolean isEmailFieldDisplayed() {
        return WaitUtil.waitForVisibility(emailField).isDisplayed();
    }
    // ========== Actions ==========

    /**Refreshes the Survey page.*/
    public void refreshPage(){
        windowManager.refreshPage();
    }
    // ========== Navigation ==========
    /**
     * Clicks the Terms and Conditions link — opens in new tab.
     * Switches to the new tab automatically.*/

    public TermsAndConditionsPage clickTermsAndConditions() {
        String originalWindow = driver.getWindowHandle();
        WaitUtil.waitForClickable(termsAndConditionsLink).click();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        return new TermsAndConditionsPage(driver);
    }

}
