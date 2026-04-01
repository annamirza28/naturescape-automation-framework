package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Make Self Storage Payment Page.
 * URL: <a href="https://naturescapelawncare.com/us/storage-payment/">Storage Payment</a>
 * Accessible from My Account page via "Make Self Storage Payment" button.
 */
public class MakeSelfStoragePaymentPage {

    private final WebDriver driver;
    private final WindowManager windowManager;

    // ========== Locators ==========
    private final By pageHeading =
            By.id("payment-heading");
    private final By selectAddressHeading =
            By.xpath("//h3[contains(.,'Select Address')]");
    private final By firstFacilityRadio =
            By.xpath("//input[@type='radio'][@value='1']");
    private final By secondFacilityRadio =
            By.xpath("//input[@type='radio'][@value='2']");
    private final By unitNumberInput =
            By.id("unit_number");
    private final By renterInfoHeading =
            By.xpath("//h3[contains(.,'Renter Information')]");
    private final By firstNameField =
            By.id("renter_first_name");
    private final By lastNameField =
            By.id("renter_last_name");
    private final By phoneField =
            By.id("renter_phone");
    private final By paymentAmountHeading =
            By.xpath("//h3[contains(.,'Payment Amount')]");
    private final By paymentAmountField =
            By.id("payment_amount");
    private final By paymentInfoHeading =
            By.xpath("//h3[contains(.,'Payment Information')]");
    private final By additionalNotesHeading =
            By.xpath("//h3[contains(.,'Additional Notes')]");


    // ========== Constructor ==========

    public MakeSelfStoragePaymentPage(WebDriver driver) {
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

    /** Checks if the page heading is displayed. */
    public boolean isHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }

    /** Returns the page heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }

    // ========== Section Validation ==========

    /** Checks if Select Address section heading is displayed. */
    public boolean isSelectAddressHeadingDisplayed() {
        return WaitUtil.waitForVisibility(selectAddressHeading)
                .isDisplayed();
    }

    /** Checks if Renter Information heading is displayed. */
    public boolean isRenterInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(renterInfoHeading)
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

    /** Checks if Additional Notes heading is displayed. */
    public boolean isAdditionalNotesHeadingDisplayed() {
        return WaitUtil.waitForVisibility(additionalNotesHeading)
                .isDisplayed();
    }

    // ========== Form Field Validation ==========

    /** Checks if unit number input is displayed. */
    public boolean isUnitNumberInputDisplayed() {
        return WaitUtil.waitForVisibility(unitNumberInput).isDisplayed();
    }

    /** Checks if first facility radio button is displayed. */
    public boolean isFirstFacilityRadioDisplayed() {
        return WaitUtil.waitForVisibility(firstFacilityRadio)
                .isDisplayed();
    }

    /** Checks if second facility radio button is displayed. */
    public boolean isSecondFacilityRadioDisplayed() {
        return WaitUtil.waitForVisibility(secondFacilityRadio)
                .isDisplayed();
    }

    /** Checks if first name field is displayed. */
    public boolean isFirstNameFieldDisplayed() {
        return WaitUtil.waitForVisibility(firstNameField).isDisplayed();
    }

    /** Checks if last name field is displayed. */
    public boolean isLastNameFieldDisplayed() {
        return WaitUtil.waitForVisibility(lastNameField).isDisplayed();
    }

    /** Checks if phone field is displayed. */
    public boolean isPhoneFieldDisplayed() {
        return WaitUtil.waitForVisibility(phoneField).isDisplayed();
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