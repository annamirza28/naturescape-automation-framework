package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.MakeSelfStoragePaymentPage;
import com.anamirza.qa.pages.MyAccountPage;
import com.anamirza.qa.utils.JavaScriptUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Make Self Storage Payment Page.
 * URL: <a href="https://naturescapelawncare.com/us/storage-payment/">Storage Payment</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading displayed correctly
 * - All sections are displayed
 * - All form fields are displayed
 * - Page accessible from My Account page
 */
public class MakeSelfStoragePaymentPageTests extends BaseTest {
    private MakeSelfStoragePaymentPage storagePage;

    // ========== Setup ==========

    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/storage-payment/");
        storagePage = new MakeSelfStoragePaymentPage(driver);
    }

    // ========== URL & Title Tests ==========

    @Test(description = "Verify Storage Payment page URL is correct")
    public void shouldNavigateToStoragePaymentPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/storage-payment/";
        String actualURL = storagePage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "Storage Payment URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }

    @Test(description = "Verify Storage Payment page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Make a Self Storage Payment";
        String actualTitle = storagePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Storage Payment title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }

    // ========== Page Load Tests ==========

    @Test(description = "Verify Make Self Storage Payment heading is displayed")
    public void shouldDisplayHeadingOnStoragePaymentPage() {
        Assert.assertTrue(storagePage.isHeadingDisplayed(),
                "Heading should be displayed on Storage Payment page");
    }

    @Test(description = "Verify heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expected = "Make Self Storage Payment";
        String actual = storagePage.getHeadingText();
        Assert.assertEquals(actual, expected,
                "Heading text is incorrect. " +
                        "Expected: " + expected +
                        " but got: " + actual);
    }
    @Test(description = "Verify unit number input is displayed")
    public void shouldDisplayUnitNumberInput() {
        Assert.assertTrue(storagePage.isUnitNumberInputDisplayed(),
                "Unit number input should be displayed");
    }

    @Test(description = "Verify first facility radio button is displayed")
    public void shouldDisplayFirstFacilityRadio() {
        Assert.assertTrue(storagePage.isFirstFacilityRadioDisplayed(),
                "First facility radio button should be displayed");
    }

    @Test(description = "Verify second facility radio button is displayed")
    public void shouldDisplaySecondFacilityRadio() {
        Assert.assertTrue(storagePage.isSecondFacilityRadioDisplayed(),
                "Second facility radio button should be displayed");
    }

    @Test(description = "Verify payment amount field is displayed")
    public void shouldDisplayPaymentAmountField() {
        Assert.assertTrue(storagePage.isPaymentAmountFieldDisplayed(),
                "Payment amount field should be displayed");
    }

    // ========== Section Tests ==========

    @Test(description = "Verify Select Address section is displayed")
    public void shouldDisplaySelectAddressSection() {
        Assert.assertTrue(storagePage.isSelectAddressHeadingDisplayed(),
                "Select Address section should be displayed");
    }

    @Test(description = "Verify Renter Information section is displayed")
    public void shouldDisplayRenterInfoSection() {
        Assert.assertTrue(storagePage.isRenterInfoHeadingDisplayed(),
                "Renter Information section should be displayed");
    }

    @Test(description = "Verify Payment Amount section is displayed")
    public void shouldDisplayPaymentAmountSection() {
        Assert.assertTrue(storagePage.isPaymentAmountHeadingDisplayed(),
                "Payment Amount section should be displayed");
    }

    @Test(description = "Verify Payment Information section is displayed")
    public void shouldDisplayPaymentInfoSection() {
        Assert.assertTrue(storagePage.isPaymentInfoHeadingDisplayed(),
                "Payment Information section should be displayed");
    }

    @Test(description = "Verify Additional Notes section is displayed")
    public void shouldDisplayAdditionalNotesSection() {
        Assert.assertTrue(storagePage.isAdditionalNotesHeadingDisplayed(),
                "Additional Notes section should be displayed");
    }

    // ========== Form Field Tests ==========

    @Test(description = "Verify first name field is displayed")
    public void shouldDisplayFirstNameField() {
        Assert.assertTrue(storagePage.isFirstNameFieldDisplayed(),
                "First name field should be displayed");
    }

    @Test(description = "Verify last name field is displayed")
    public void shouldDisplayLastNameField() {
        Assert.assertTrue(storagePage.isLastNameFieldDisplayed(),
                "Last name field should be displayed");
    }

    @Test(description = "Verify phone field is displayed")
    public void shouldDisplayPhoneField() {
        Assert.assertTrue(storagePage.isPhoneFieldDisplayed(),
                "Phone field should be displayed");
    }

    // ========== Refresh & Navigation Tests ==========

    @Test(description = "Verify page reloads correctly after refresh")
    public void shouldRefreshStoragePaymentPage() {
        String expectedURL =
                "https://naturescapelawncare.com/us/storage-payment/";
        storagePage.refreshPage();
        Assert.assertEquals(storagePage.getPageURL(), expectedURL,
                "URL should remain correct after refresh");
        Assert.assertTrue(storagePage.isHeadingDisplayed(),
                "Heading should still be visible after refresh");
    }

    // ========== Navigation Tests ==========

    @Test(description = "Verify Storage Payment accessible from My Account")
    public void shouldNavigateToStoragePaymentFromMyAccount() {
        driver.get("https://naturescapelawncare.com/us/account/");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        MakeSelfStoragePaymentPage page = myAccountPage.clickMakeSelfStoragePayment();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Storage Payment page should load from " +
                        "My Account page");
    }
}