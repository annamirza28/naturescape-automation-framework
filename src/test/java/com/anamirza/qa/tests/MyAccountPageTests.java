package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.GetStartedPage;
import com.anamirza.qa.pages.MakeSelfStoragePaymentPage;
import com.anamirza.qa.pages.MyAccountPage;
import com.anamirza.qa.pages.PaymentPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape My Account Page.
 * URL: <a href="https://naturescapelawncare.com/us/account/">My Account Page</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading displayed correctly
 * - All buttons are displayed
 * - All form fields are displayed
 * - Navigation to Payment, Storage Payment, Get Started pages
 */
public class MyAccountPageTests extends BaseTest {
    private MyAccountPage myAccountPage;

    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/account/");
        myAccountPage = new MyAccountPage(driver);
    }

    // ========== URL & Title Tests ==========

    @Test(description = "Verify My Account page URL is correct")
    public void shouldNavigateToMyAccountPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/account/";
        String actualURL = myAccountPage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "My Account URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }

    @Test(description = "Verify My Account page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Account | Naturescape";
        String actualTitle = myAccountPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "My Account title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }

    // ========== Page Load Tests ==========

    @Test(description = "Verify My Account heading is displayed")
    public void shouldDisplayMyAccountHeading() {
        Assert.assertTrue(myAccountPage.isPageHeadingDisplayed(),
                "My Account heading should be displayed");
    }

    @Test(description = "Verify My Account heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expected = "My Account";
        String actual = myAccountPage.getPageHeadingText();
        Assert.assertEquals(actual, expected,
                "My Account heading text is incorrect. " +
                        "Expected: " + expected +
                        " but got: " + actual);
    }

    // ========== Button Tests ==========

    @Test(description = "Verify Make a Payment button is displayed")
    public void shouldDisplayMakePaymentButton() {
        Assert.assertTrue(myAccountPage.isMakePaymentButtonDisplayed(),
                "Make a Payment button should be displayed");
    }

    @Test(description = "Verify Add New Service button is displayed")
    public void shouldDisplayAddNewServiceButton() {
        Assert.assertTrue(myAccountPage.isAddNewServiceButtonDisplayed(),
                "Add New Service button should be displayed");
    }

    @Test(description = "Verify Make Self Storage Payment button is displayed")
    public void shouldDisplayMakeSelfStoragePaymentButton() {
        Assert.assertTrue(myAccountPage.isMakeSelfStoragePaymentButtonDisplayed(),
                "Make Self Storage Payment button should be displayed");
    }

    // ========== Form Field Tests ==========

    @Test(description = "Verify Phone field is displayed")
    public void shouldDisplayPhoneField() {
        Assert.assertTrue(myAccountPage.isPhoneFieldDisplayed(),
                "Phone field should be displayed");
    }

    @Test(description = "Verify Email field is displayed")
    public void shouldDisplayEmailField() {
        Assert.assertTrue(myAccountPage.isEmailFieldDisplayed(),
                "Email field should be displayed");
    }

    @Test(description = "Verify Text button is displayed")
    public void shouldDisplayTextButton() {
        Assert.assertTrue(myAccountPage.isTextButtonDisplayed(),
                "Text button should be displayed");
    }

    @Test(description = "Verify Call button is displayed")
    public void shouldDisplayCallButton() {
        Assert.assertTrue(myAccountPage.isCallButtonDisplayed(),
                "Call button should be displayed");
    }

    @Test(description = "Verify Email button is displayed")
    public void shouldDisplayEmailButton() {
        Assert.assertTrue(myAccountPage.isEmailButtonDisplayed(),
                "Email button should be displayed");
    }

    @Test(description = "Verify Code input is displayed")
    public void shouldDisplayCodeInput() {
        Assert.assertTrue(myAccountPage.isCodeInputDisplayed(),
                "Code input should be displayed");
    }

    @Test(description = "Verify Login button is displayed")
    public void shouldDisplayLoginButton() {
        Assert.assertTrue(myAccountPage.isLoginButtonDisplayed(),
                "Login button should be displayed");
    }

    // ========== Navigation Tests ==========

    @Test(description = "Verify Make a Payment navigates to Payment page")
    public void shouldNavigateToPaymentPage() {
        PaymentPage paymentPage = myAccountPage.clickMakePayment();
        Assert.assertTrue(paymentPage.isHeadingDisplayed(),
                "Payment page should load after clicking " +
                        "Make a Payment button");
    }

    @Test(description = "Verify Make Self Storage Payment navigates correctly")
    public void shouldNavigateToStoragePaymentPage() {
        MakeSelfStoragePaymentPage storagePage = myAccountPage.clickMakeSelfStoragePayment();
        Assert.assertTrue(storagePage.isHeadingDisplayed(),
                "Storage Payment page should load after clicking " +
                        "Make Self Storage Payment button");
    }

    @Test(description = "Verify Add New Service navigates to Get Started page")
    public void shouldNavigateToGetStartedPage() {
        GetStartedPage getStartedPage = myAccountPage.clickAddNewService();
        Assert.assertTrue(getStartedPage.isHeadingDisplayed(),
                "Get Started page should load after clicking " +
                        "Add New Service button");
    }
}