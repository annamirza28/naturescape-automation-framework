package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Page Object for the Naturescape Get Started Page.
 * URL: <a href="https://naturescapelawncare.com/us/get_started/">Get Started Page</a>
 * Page has two states:
 * - State 1 (initial): Contact Info + About Your Lawn + Price Estimator placeholder
 * - State 2 (after ZIP + phone entered): Full form with Property Info,
 *   Account Info, Notes, and Payment Info sections appear
 */
public class GetStartedPage {
    private final WebDriver driver;
    // ========== Locators — Always Visible ==========
    private final By pageHeading = By.xpath("//h1[text()='Get Started!']");
    private final By phoneInput = By.id("phone");
    private final By emailInput = By.xpath("//input[@type='text' " +
                    "and @class='contactInfoInputWidth'][2]");
    private final By zipCodeInput = By.id("property_zip");
    private final By lawnSizeInput = By.xpath("//input[@type='number']");
    private final By notSureCheckBox = By.xpath("//input[@type='checkbox'][1]");
    private final By slider = By.xpath("//input[@type='range']");
    private final By priceEstimatorHeading = By.xpath("//h3[text()='Price Estimator']");
    /**Locators — Visible After ZIP + Phone Entered */
    private final By firstNameField = By.id("property_first_name");
    private final By lastNameField = By.id("property_last_name");
    private final By addressField = By.id("property_address");
    private final By stateDropdown = By.id("property_state");
    private final By sameAsServiceAddressCheckbox = By.xpath("//label[contains(.,'Same as Service Address')]" +
                    "//input[@type='checkbox']");
    private final By accountInfoHeading = By.xpath("//h3[text()='Account Information']");
    private final By billingFirstNameField = By.id("billing_first_name");
    private final By billingLastNameField = By.id("billing_last_name");
    private final By billingAddressField = By.id("billing_address");
    private final By billingCityField = By.id("billing_city");
    private final By billingStateDropdown = By.id("billing_state");
    private final By billingZipField = By.id("billing_zip");
    private final By notesHeading = By.xpath("//h3[text()='Notes for Your Local Branch']");
    private final By howDidYouHearDropdown = By.xpath("//select[.//option[@value='word_of_mouth']]");
    private final By notesTextArea = By.xpath("//textarea[@maxlength='149']");
    private final By paymentInfoHeading = By.xpath("//h3[text()='Payment Information']");
    private final By submitButton = By.cssSelector("input[value='Submit']");
    // ========== Constructor ==========
    public GetStartedPage(WebDriver driver) {
        this.driver = driver;
    }
    // ========== Page Validation ==========
    /** Returns the current page URL. */
    public String getPageURL() {
        return driver.getCurrentUrl();
    }
    /** Checks if the Get Started heading is displayed. */
    public boolean isHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /** Returns the heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }
    // ========== Contact Information Validation ==========
    /** Checks if phone input is displayed. */
    public boolean isPhoneInputDisplayed() {
        return WaitUtil.waitForVisibility(phoneInput).isDisplayed();
    }
    /** Checks if email input is displayed. */
    public boolean isEmailInputDisplayed() {
        return WaitUtil.waitForVisibility(emailInput).isDisplayed();
    }
    // ========== About Your Lawn Validation ==========
    /** Checks if ZIP code input is displayed. */
    public boolean isZipCodeInputDisplayed() {
        return WaitUtil.waitForVisibility(zipCodeInput).isDisplayed();
    }
    /** Checks if lawn size input is displayed. */
    public boolean isLawnSizeInputDisplayed() {
        return WaitUtil.waitForVisibility(lawnSizeInput).isDisplayed();
    }
    /** Checks if Not Sure checkbox is displayed. */
    public boolean isNotSureCheckBoxDisplayed() {
        return WaitUtil.waitForVisibility(notSureCheckBox).isDisplayed();
    }
    /** Checks if lawn size slider is displayed. */
    public boolean isSliderDisplayed() {
        return WaitUtil.waitForVisibility(slider).isDisplayed();
    }
    // ========== Price Estimator Validation ==========
    /** Checks if Price Estimator heading is displayed. */
    public boolean isPriceEstimatorDisplayed() {
        return WaitUtil.waitForVisibility(priceEstimatorHeading).isDisplayed();
    }
    // ========== Property Information Validation ==========
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
    // ========== Account Information Validation ==========
    /** Checks if Account Information heading is displayed. */
    public boolean isAccountInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(accountInfoHeading).isDisplayed();
    }
    /** Checks if billing first name field is displayed. */
    public boolean isBillingFirstNameDisplayed() {
        return WaitUtil.waitForVisibility(billingFirstNameField).isDisplayed();
    }
    /** Checks if billing state dropdown is displayed. */
    public boolean isBillingStateDropdownDisplayed() {
        return WaitUtil.waitForVisibility(billingStateDropdown).isDisplayed();
    }
    // ========== Notes Validation ==========
    /** Checks if Notes heading is displayed. */
    public boolean isNotesHeadingDisplayed() {
        return WaitUtil.waitForVisibility(notesHeading).isDisplayed();
    }
    /** Checks if How Did You Hear dropdown is displayed. */
    public boolean isHowDidYouHearDropdownDisplayed() {
        return WaitUtil.waitForVisibility(howDidYouHearDropdown).isDisplayed();
    }
    /** Checks if notes textarea is displayed. */
    public boolean isNotesTextAreaDisplayed() {
        return WaitUtil.waitForVisibility(notesTextArea).isDisplayed();
    }
    // ========== Payment Information Validation ==========
    /** Checks if Payment Information heading is displayed. */
    public boolean isPaymentInfoHeadingDisplayed() {
        return WaitUtil.waitForVisibility(paymentInfoHeading).isDisplayed();
    }
    // ========== Actions — Contact Information ==========
    /** Enters phone number. */
    public void enterPhone(String phone) {
        WaitUtil.waitForVisibility(phoneInput).sendKeys(phone);
    }
    /** Enters email address. */
    public void enterEmail(String email) {
        WaitUtil.waitForVisibility(emailInput).sendKeys(email);
    }
    // ========== Actions — About Your Lawn ==========
    /** Enters ZIP code. */
    public void enterZipCode(String zip) {
        WebElement field = WaitUtil.waitForVisibility(zipCodeInput);
        field.clear();
        field.sendKeys(zip);
        field.sendKeys(Keys.TAB);
    }
    /** Clears and enters lawn size value. */
    public void enterLawnSize(String size) {
        WebElement field = WaitUtil.waitForVisibility(lawnSizeInput);
        field.clear();
        field.sendKeys(size);
    }
    /** Clicks the Not Sure checkbox. */
    public void clickNotSureCheckBox() {
        WaitUtil.waitForClickable(notSureCheckBox).click();
    }
    // ========== Actions — Property Information ==========
    /** Enters first name in Property Information. */
    public void enterFirstName(String firstName) {
        WaitUtil.waitForVisibility(firstNameField).sendKeys(firstName);
    }

    /** Enters last name in Property Information. */
    public void enterLastName(String lastName) {
        WaitUtil.waitForVisibility(lastNameField).sendKeys(lastName);
    }

    /** Enters address in Property Information. */
    public void enterAddress(String address) {
        WaitUtil.waitForVisibility(addressField).sendKeys(address);
    }

    /** Selects state from Property Information dropdown. */
    public void selectState(String state) {
        WebElement dropdown = WaitUtil.waitForVisibility(stateDropdown);
        new Select(dropdown).selectByVisibleText(state);
    }
    // ========== Actions — Account Information ==========
    /** Clicks Same as Service Address checkbox. */
    public void clickSameAsServiceAddress() {
        WaitUtil.waitForClickable(sameAsServiceAddressCheckbox).click();
    }
    /** Enters billing first name. */
    public void enterBillingFirstName(String firstName) {
        WaitUtil.waitForVisibility(billingFirstNameField).sendKeys(firstName);
    }
    /** Enters billing last name. */
    public void enterBillingLastName(String lastName) {
        WaitUtil.waitForVisibility(billingLastNameField).sendKeys(lastName);
    }
    /** Enters billing address. */
    public void enterBillingAddress(String address) {
        WaitUtil.waitForVisibility(billingAddressField).sendKeys(address);
    }
    /** Enters billing city. */
    public void enterBillingCity(String city) {
        WaitUtil.waitForVisibility(billingCityField).sendKeys(city);
    }
    /** Selects billing state from dropdown. */
    public void selectBillingState(String state) {
        WebElement dropdown = WaitUtil.waitForVisibility(billingStateDropdown);
        new Select(dropdown).selectByVisibleText(state);
    }
    /** Enters billing ZIP code. */
    public void enterBillingZip(String zip) {
        WaitUtil.waitForVisibility(billingZipField).sendKeys(zip);
    }
    // ========== Actions — Notes ==========
    /** Selects how did you hear option from dropdown. */
    public void selectHowDidYouHear(String option) {
        WebElement dropdown = WaitUtil.waitForVisibility(howDidYouHearDropdown);
        new Select(dropdown).selectByVisibleText(option);
    }
    /** Enters notes text. */
    public void enterNotes(String notes) {
        WaitUtil.waitForVisibility(notesTextArea).sendKeys(notes);
    }
    // ========== Combined Flow Actions ==========
    /**
     * Fills Contact Information section.
     * This triggers the page to expand with more sections.
     */
    public void fillContactInfo(String phone, String email,
                                String zip, String lawnSize) {
        enterPhone(phone);
        enterEmail(email);
        enterZipCode(zip);
        enterLawnSize(lawnSize);
        waitForFormExpansion();
    }
    /**
     * Fills Property Information section.
     * Only available after fillContactInfo() is called.
     */
    public void fillPropertyInfo(String firstName, String lastName,
                                 String address, String state) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterAddress(address);
        selectState(state);
    }
    /**
     * Fills Account Information section with billing details.
     * Only available after fillContactInfo() is called.
     */
    public void fillBillingInfo(String firstName, String lastName,
                                String address, String city,
                                String state, String zip) {
        enterBillingFirstName(firstName);
        enterBillingLastName(lastName);
        enterBillingAddress(address);
        enterBillingCity(city);
        selectBillingState(state);
        enterBillingZip(zip);
    }
    // ========== Scroll Actions ==========
    /**
     * Scrolls to the bottom of the page.
     * Useful when form expands and new sections appear below.
     */
    public void scrollToSubmitButton() {
        JavaScriptUtil.scrollToBottom();
    }
    /**
     * Scrolls to the Price Estimator section.
     */
    public void scrollToPriceEstimator() {
        JavaScriptUtil.scrollToElement(
                WaitUtil.waitForVisibility(priceEstimatorHeading));
    }
    /**
     * Scrolls to the Property Information section.
     */
    public void scrollToPropertyInfo() {
        JavaScriptUtil.scrollToElement(
                WaitUtil.waitForVisibility(firstNameField));
    }
    /**
     * Scrolls to the Account Information section.
     */
    public void scrollToAccountInfo() {
        JavaScriptUtil.scrollToElement(
                WaitUtil.waitForVisibility(accountInfoHeading));
    }
    /**
     * Scrolls to the Notes section.
     */
    public void scrollToNotes() {
        JavaScriptUtil.scrollToElement(WaitUtil.waitForVisibility(notesHeading));
    }
    /**
     * Scrolls to the Payment Information section.
     */
    public void scrollToPaymentInfo() {
        JavaScriptUtil.scrollToBottom();
        WebElement element = WaitUtil.waitForVisibility(paymentInfoHeading);
        JavaScriptUtil.scrollToElement(element);
    }
    public void scrollToBottom(){
        JavaScriptUtil.scrollToBottom();
    }
    // ========== Debug Helpers ==========
    /**
     * Highlights the page heading with a red border.
     * Useful for debugging — visible in failure screenshots.
     */
    public void highlightHeading() {
        JavaScriptUtil.highlight(WaitUtil.waitForVisibility(pageHeading));
    }
    /**
     * Returns the page title using JavaScript.
     * Alternative to driver.getTitle() — more reliable in some browsers.
     */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /**
     * Waits for the form to expand by waiting for the first name field
     * to become visible after entering ZIP and phone.
     * Call this after fillContactInfo() or entering ZIP/phone manually.
     */
    public void waitForFormExpansion() {
        WaitUtil.waitForVisibility(firstNameField);
    }
}

