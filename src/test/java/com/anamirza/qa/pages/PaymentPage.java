package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Naturescape Payment Page.
 * URL: <a href="https://naturescapelawncare.com/us/payment/">Payment Page</a>
 * Accessible from My Account page via "Make a Payment" button.
 */
public class PaymentPage {
    private final WebDriver driver;
    private final WindowManager windowManager;

    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[text()='Payment']");
    private final By contactInfoHeading = By.xpath("//h3[text()='Contact Information']");
    private final By phoneField = By.id("phone");
    private final By emailField = By.xpath("//label[text()='Email']" +
                    "/following-sibling::input[1]");
    private final By propertyInfoHeading = By.xpath("//h3[text()='Property Information']");
    private final By firstNameField = By.id("property_first_name");
    private final By lastNameField = By.id("property_last_name");
    private final By addressField = By.id("property_address");
    private final By stateDropdown = By.id("property_state");
    private final By zipField = By.id("property_zip");
    private final By paymentAmountHeading = By.xpath("//h3[text()='Payment Amount']");
    private final By paymentAmountField = By.id("payment_amount");
    private final By paymentInfoHeading = By.xpath("//h3[text()='Payment Information']");
    private final By notesHeading = By.xpath("//h3[text()='Notes for Your Local Branch']");


    // ========== Constructor ==========
    public PaymentPage(WebDriver driver) {
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

    /** Checks if the Payment heading is displayed. */
    public boolean isHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }

    /** Returns the heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }

    // ========== Section Validation ==========

    /** Checks if Contact Information heading is displayed. */
    public boolean isContactInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(contactInfoHeading)
                .isDisplayed();
    }

    /** Checks if Property Information heading is displayed. */
    public boolean isPropertyInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(propertyInfoHeading)
                .isDisplayed();
    }

    /** Checks if Payment Amount heading is displayed. */
    public boolean isPaymentAmountHeadingDisplayed() {
        return WaitUtil.waitForVisibility(paymentAmountHeading)
                .isDisplayed();
    }

    /** Checks if Payment Information heading is displayed. */
    public boolean isPaymentInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(paymentInfoHeading)
                .isDisplayed();
    }

    /** Checks if Notes heading is displayed. */
    public boolean isNotesHeadingDisplayed() {
        return WaitUtil.waitForVisibility(notesHeading).isDisplayed();
    }

    // ========== Form Field Validation ==========

    /** Checks if phone field is displayed. */
    public boolean isPhoneFieldDisplayed() {
        return WaitUtil.waitForVisibility(phoneField).isDisplayed();
    }

    /** Checks if email field is displayed. */
    public boolean isEmailFieldDisplayed() {
        return WaitUtil.waitForVisibility(emailField).isDisplayed();
    }

    /** Checks if first name field is displayed. */
    public boolean isFirstNameFieldDisplayed() {
        return WaitUtil.waitForVisibility(firstNameField).isDisplayed();
    }

    /** Checks if last name field is displayed. */
    public boolean isLastNameFieldDisplayed() {
        return WaitUtil.waitForVisibility(lastNameField).isDisplayed();
    }

    /** Checks if address field is displayed. */
    public boolean isAddressFieldDisplayed() {
        return WaitUtil.waitForVisibility(addressField).isDisplayed();
    }

    /** Checks if state dropdown is displayed. */
    public boolean isStateDropdownDisplayed() {
        return WaitUtil.waitForVisibility(stateDropdown).isDisplayed();
    }

    /** Checks if ZIP field is displayed. */
    public boolean isZipFieldDisplayed() {
        return WaitUtil.waitForVisibility(zipField).isDisplayed();
    }

    /** Checks if payment amount field is displayed. */
    public boolean isPaymentAmountFieldDisplayed() {
        return WaitUtil.waitForVisibility(paymentAmountField)
                .isDisplayed();
    }
    // ========== Actions ==========

    /** Refreshes the page. */
    public void refreshPage() {
        windowManager.refreshPage();
    }

    /** Navigates back to previous page. */
    public void goBack() {
        windowManager.goBack();
    }
}