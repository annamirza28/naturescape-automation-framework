package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.GetStartedPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Get Started Page.
 * URL: <a href="https://naturescapelawncare.com/us/get_started/">Get Started Page</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading is displayed with correct text
 * - All initial form fields are displayed
 * - Price Estimator section is displayed
 * - Form expands correctly after entering phone and ZIP
 * - All expanded sections are displayed
 */
public class GetStartedPageTests extends BaseTest {
    private GetStartedPage getStartedPage;

    @BeforeMethod
    public void setUpPage(){
        driver.get("https://naturescapelawncare.com/us/get_started/");
        getStartedPage = new GetStartedPage(driver);
    }
    // ========== URL & Title Tests ==========

    @Test(description = "Verify Get Started page URL is correct")
    public void shouldNavigateToGetStartedPageWithCorrectURL(){
        String expectedURL = "https://naturescapelawncare.com/us/get_started/";
        String actualURL = getStartedPage.getPageURL();
        Assert.assertEquals(actualURL,expectedURL,
                "Get Started page URL is incorrect."+
                         "Expected:" + expectedURL+
                         "but got:" +actualURL);
    }
    @Test(description = "Verify Get Started page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Get Started";
        String actualTitle = getStartedPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Get Started page title is incorrect. " +
                         "Expected to contain: " + expectedTitle +
                         " but got: " + actualTitle);
    }
    // ========== Page Load Tests ==========
    @Test(description = "Verify Get Started page heading is displayed")
    public void shouldDisplayHeadingOnGetStartedPage(){
        Assert.assertTrue(getStartedPage.isHeadingDisplayed(),
                "Heading should be displayed on Get Started Page");
    }
    @Test(description = "Verify Get Started page heading text is correct")
    public void shouldDisplayCorrectHeadingText(){
        String expectedHeadingText = "Get Started!";
        String actualHeadingText = getStartedPage.getHeadingText();
        Assert.assertEquals(actualHeadingText,expectedHeadingText,
                "Get Started heading text is correct."+
                "Expected:" + expectedHeadingText +
                "but got:" + actualHeadingText);
    }
    // ========== Contact Information Tests ==========
    @Test(description = "Verify phone input is displayed")
    public void shouldDisplayPhoneInput(){
        Assert.assertTrue(getStartedPage.isPhoneInputDisplayed(),
                "Phone Input should be displayed.");
    }
    @Test(description = "Verify email input is displayed")
    public void shouldDisplayEmailInput(){
        Assert.assertTrue(getStartedPage.isEmailInputDisplayed(),
                "Email Input should be displayed.");
    }
    // ========== About Your Lawn Tests ==========
    @Test(description = "Verify ZIP code input is displayed")
    public void shouldDisplayZipCodeInput(){
        Assert.assertTrue(getStartedPage.isZipCodeInputDisplayed(),
                "Zip Code Input should be displayed.");
    }
    @Test(description = "Verify lawn size input is displayed")
    public void shouldDisplayLawnSizeInput(){
        Assert.assertTrue(getStartedPage.isLawnSizeInputDisplayed(),
                "Lawn Size Input should be displayed.");
    }
    @Test(description = "Verify Not Sure checkbox is displayed")
    public void shouldDisplayNotSureCheckbox(){
        Assert.assertTrue(getStartedPage.isNotSureCheckBoxDisplayed(),
                "Not Sure checkbox should be displayed");
    }
    @Test(description = "Verify lawn size slider is displayed")
    public void shouldDisplayLawnSizeSlider() {
        Assert.assertTrue(getStartedPage.isSliderDisplayed(),
                "Lawn size slider should be displayed");
    }
    // ========== Price Estimator Tests ==========
    @Test(description = "Verify Price Estimator section is displayed")
    public void shouldDisplayPriceEstimatorSection() {
        Assert.assertTrue(getStartedPage.isPriceEstimatorDisplayed(),
                "Price Estimator section should be displayed");
    }
    // ========== Form Expansion Tests ==========
    // Note: these tests verify the form expands correctly
    // after entering phone and ZIP code
    @Test(description = "Verify Property Info section appears " + "after entering phone and ZIP")
    public void shouldExpandFormWithPropertyInfoAfterContactDetails(){
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.scrollToPropertyInfo();
        Assert.assertTrue(getStartedPage.isFirstNameFieldDisplayed(),
                "First name field should appear after entering " +
                         "phone and ZIP");
        Assert.assertTrue(getStartedPage.isLastNameFieldDisplayed(),
                "Last name field should appear after entering " +
                        "phone and ZIP");
        Assert.assertTrue(getStartedPage.isAddressFieldDisplayed(),
                "Address field should appear after entering " +
                         "phone and ZIP");
        Assert.assertTrue(getStartedPage.isStateDropdownDisplayed(),
                "State dropdown should appear after entering " +
                        "phone and ZIP");
    }
    @Test(description = "Verify Account Info section appears " + "after entering contact details")
    public void shouldExpandFormWithAccountInfoAfterContactDetails() {
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.scrollToAccountInfo();
        Assert.assertTrue(getStartedPage.isAccountInfoHeadingDisplayed(),
                "Account Info heading should appear after " +
                        "entering contact details");
        Assert.assertTrue(getStartedPage.isBillingFirstNameDisplayed(),
                "Billing first name should appear after " +
                        "entering contact details");
    }
    @Test(
            description = "Verify Notes section appears after entering contact details",
            retryAnalyzer = com.anamirza.qa.listeners.RetryAnalyzer.class
    )
    public void shouldExpandFormWithNotesSectionAfterContactDetails() {
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.waitForFormExpansion();
        getStartedPage.scrollToBottom();
        getStartedPage.scrollToNotes();
        Assert.assertTrue(getStartedPage.isNotesHeadingDisplayed(),
                "Notes heading should appear after entering contact details");
        Assert.assertTrue(getStartedPage.isHowDidYouHearDropdownDisplayed(),
                "How Did You Hear dropdown should be displayed");
        Assert.assertTrue(getStartedPage.isNotesTextAreaDisplayed(),
                "Notes textarea should be displayed");
    }
    @Test(description = "Verify Payment Info section appears " +
                        "after entering contact details",
            retryAnalyzer = com.anamirza.qa.listeners.RetryAnalyzer.class
    )
    public void shouldExpandFormWithPaymentInfoAfterContactDetails() {
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.waitForFormExpansion();
        getStartedPage.scrollToPaymentInfo();
        /** Assert — only check heading, not submit button
        Submit button is inside payment iframe — not directly accessible*/
        Assert.assertTrue(getStartedPage.isPaymentInfoHeadingDisplayed(),
                "Payment Info heading should appear after " +
                        "entering contact details");
    }
    // ========== Full Form Fill Test ==========
    @Test(
            description = "Verify full form can be filled with valid data",
            retryAnalyzer = com.anamirza.qa.listeners.RetryAnalyzer.class
    )
    public void shouldFillFullFormWithValidData() {
        // Act — fill contact info
        getStartedPage.fillContactInfo(
                "1234567890",
                "test@email.com",
                "60585",
                "5");

        // Act — fill property info
        getStartedPage.scrollToPropertyInfo();
        getStartedPage.fillPropertyInfo(
                "John", "Doe", "123 Main St", "Illinois");

        // Act — use Same as Service Address
        // instead of filling billing manually
        getStartedPage.scrollToAccountInfo();
        getStartedPage.waitForFormExpansion(); // ← ADD THIS
        getStartedPage.clickSameAsServiceAddress();

        // Act — fill notes
        getStartedPage.scrollToBottom();
        getStartedPage.scrollToNotes();
        getStartedPage.selectHowDidYouHear(
                "Search Engine (Google, Bing, etc)");
        getStartedPage.enterNotes("Test automation note");

        // Act — scroll to payment
        getStartedPage.scrollToPaymentInfo();

        // Assert
        Assert.assertTrue(
                getStartedPage.isPaymentInfoHeadingDisplayed(),
                "Payment Info heading should be visible after " +
                        "filling all form fields");
    }
    // ========== Debug Helper Tests ==========
    @Test(description = "Verify heading can be highlighted for debugging")
    public void shouldHighlightPageHeading() {
        getStartedPage.highlightHeading();
        Assert.assertTrue(getStartedPage.isHeadingDisplayed(),
                "Heading should still be displayed after highlighting");
    }
// ========== Scroll Tests ==========
    @Test(description = "Verify page scrolls to Price Estimator section")
    public void shouldScrollToPriceEstimatorSection() {
        getStartedPage.scrollToPriceEstimator();
        Assert.assertTrue(getStartedPage.isPriceEstimatorDisplayed(),
                "Price Estimator should be visible after scrolling to it");
    }
// ========== Checkbox Tests ==========
    @Test(description = "Verify Not Sure checkbox can be clicked")
    public void shouldClickNotSureCheckBox() {
        getStartedPage.clickNotSureCheckBox();
        Assert.assertTrue(getStartedPage.isNotSureCheckBoxDisplayed(),
                "Not Sure checkbox should still be displayed after click");
    }
    @Test(description = "Verify Same As Service Address checkbox " +
            "can be clicked after form expansion")
    public void shouldClickSameAsServiceAddressCheckbox() {
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.waitForFormExpansion();
        getStartedPage.scrollToAccountInfo();
        // Assert — billing fields visible BEFORE clicking checkbox
        Assert.assertTrue(getStartedPage.isBillingFirstNameDisplayed(),
                "Billing first name should be visible before " +
                        "clicking Same as Service Address");
        // Act — click checkbox
        getStartedPage.clickSameAsServiceAddress();
        // Assert — account info heading still visible after click
        Assert.assertTrue(getStartedPage.isAccountInfoHeadingDisplayed(),
                "Account Info heading should still be visible " +
                        "after clicking Same as Service Address");
    }
// ========== Billing State Dropdown Tests ==========
    @Test(description = "Verify billing state dropdown is displayed " +
            "after form expansion")
    public void shouldDisplayBillingStateDropdown() {
        String phone = "1234567890";
        String zip = "60585";
        String lawnSize = "5";
        getStartedPage.enterPhone(phone);
        getStartedPage.enterZipCode(zip);
        getStartedPage.enterLawnSize(lawnSize);
        getStartedPage.scrollToAccountInfo();
        Assert.assertTrue(getStartedPage.isBillingStateDropdownDisplayed(),
                "Billing state dropdown should be displayed " +
                        "after form expansion");
    }

}

