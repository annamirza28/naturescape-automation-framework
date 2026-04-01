package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.MyAccountPage;
import com.anamirza.qa.pages.PaymentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Payment Page.
 * URL: <a href="https://naturescapelawncare.com/us/payment/">Payment Page</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading displayed correctly
 * - All sections are displayed
 * - All form fields are displayed
 * - Page accessible from My Account page
 */
public class PaymentPageTests extends BaseTest {
    private PaymentPage paymentPage;

    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/payment/");
        paymentPage = new PaymentPage(driver);
    }

    // ========== URL & Title Tests ==========

    @Test(description = "Verify Payment page URL is correct")
    public void shouldNavigateToPaymentPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/payment/";
        String actualURL = paymentPage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "Payment page URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }
    @Test(description = "Verify Payment page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Make a Payment";
        String actualTitle = paymentPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Payment page title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }

    // ========== Page Load Tests ==========

    @Test(description = "Verify Payment heading is displayed")
    public void shouldDisplayHeadingOnPaymentPage() {
        Assert.assertTrue(paymentPage.isHeadingDisplayed(),
                "Heading should be displayed on Payment page");
    }

    @Test(description = "Verify Payment heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expected = "Payment";
        String actual = paymentPage.getHeadingText();
        Assert.assertEquals(actual, expected,
                "Payment heading text is incorrect. " +
                        "Expected: " + expected +
                        " but got: " + actual);
    }

    // ========== Section Tests ==========

    @Test(description = "Verify Contact Information section is displayed")
    public void shouldDisplayContactInfoSection() {
        Assert.assertTrue(paymentPage.isContactInfoHeadingDisplayed(),
                "Contact Information section should be displayed");
    }

    @Test(description = "Verify Property Information section is displayed")
    public void shouldDisplayPropertyInfoSection() {
        Assert.assertTrue(paymentPage.isPropertyInfoHeadingDisplayed(),
                "Property Information section should be displayed");
    }
    @Test(description = "Verify Payment Amount section is displayed")
    public void shouldDisplayPaymentAmountSection() {
        Assert.assertTrue(paymentPage.isPaymentAmountHeadingDisplayed(),
                "Payment Amount section should be displayed");
    }

    @Test(description = "Verify Payment Information section is displayed")
    public void shouldDisplayPaymentInfoSection() {
        Assert.assertTrue(paymentPage.isPaymentInfoHeadingDisplayed(),
                "Payment Information section should be displayed");
    }

    @Test(description = "Verify Notes section is displayed")
    public void shouldDisplayNotesSection() {
        Assert.assertTrue(paymentPage.isNotesHeadingDisplayed(),
                "Notes section should be displayed");
    }

    // ========== Form Field Tests ==========

    @Test(description = "Verify phone field is displayed")
    public void shouldDisplayPhoneField() {
        Assert.assertTrue(paymentPage.isPhoneFieldDisplayed(),
                "Phone field should be displayed");
    }

    @Test(description = "Verify email field is displayed")
    public void shouldDisplayEmailField() {
        Assert.assertTrue(paymentPage.isEmailFieldDisplayed(),
                "Email field should be displayed");
    }

    @Test(description = "Verify first name field is displayed")
    public void shouldDisplayFirstNameField() {
        Assert.assertTrue(paymentPage.isFirstNameFieldDisplayed(),
                "First name field should be displayed");
    }

    @Test(description = "Verify last name field is displayed")
    public void shouldDisplayLastNameField() {
        Assert.assertTrue(paymentPage.isLastNameFieldDisplayed(),
                "Last name field should be displayed");
    }

    @Test(description = "Verify address field is displayed")
    public void shouldDisplayAddressField() {
        Assert.assertTrue(paymentPage.isAddressFieldDisplayed(),
                "Address field should be displayed");
    }

    @Test(description = "Verify state dropdown is displayed")
    public void shouldDisplayStateDropdown() {
        Assert.assertTrue(paymentPage.isStateDropdownDisplayed(),
                "State dropdown should be displayed");
    }

    @Test(description = "Verify ZIP field is displayed")
    public void shouldDisplayZipField() {
        Assert.assertTrue(paymentPage.isZipFieldDisplayed(),
                "ZIP field should be displayed");
    }

    @Test(description = "Verify payment amount field is displayed")
    public void shouldDisplayPaymentAmountField() {
        Assert.assertTrue(paymentPage.isPaymentAmountFieldDisplayed(),
                "Payment amount field should be displayed");
    }

    // ========== Refresh Tests ==========

    @Test(description = "Verify Payment page reloads correctly after refresh")
    public void shouldRefreshPaymentPage() {
        String expectedURL = "https://naturescapelawncare.com/us/payment/";
        paymentPage.refreshPage();
        Assert.assertEquals(paymentPage.getPageURL(), expectedURL,
                "URL should remain correct after refresh");
        Assert.assertTrue(paymentPage.isHeadingDisplayed(),
                "Heading should still be visible after refresh");
    }

    // ========== Navigation Tests ==========

    @Test(description = "Verify Payment page accessible from My Account")
    public void shouldNavigateToPaymentFromMyAccount() {
        driver.get("https://naturescapelawncare.com/us/account/");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        PaymentPage page = myAccountPage.clickMakePayment();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Payment page should load from My Account page");
    }
}