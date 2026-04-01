package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.ContactUsPage;
import com.anamirza.qa.pages.CustomerServiceResponsePage;
import com.anamirza.qa.pages.JobListingsAtNaturescapePage;
import com.anamirza.qa.pages.NaturescapeLocationsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Test suite for the Contact Us Page.
 * URL: <a href="https://naturescapelawncare.com/us/contactus/">Contact Us</a>
 * Verifies:
 * - Correct URL and page title after navigation
 * - Page heading is displayed correctly
 * - Contact Info button is enabled
 * - ZIP code search works for valid and invalid ZIPs
 * - Page refresh works correctly
 * - Browser back navigation works
 * - Navigation to Locations, Career, and Survey pages
 */
public class ContactUsPageTests extends BaseTest {
    private ContactUsPage contactUsPage;
    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/contactus/");// Navigate directly to Contact Us page
        contactUsPage = new ContactUsPage(driver);// and initialize the page object
    }
    @Test(description = "Verify Contact Us page URL is correct after navigation")
    public void shouldNavigateToContactUsPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/contactus/";// Arrange
        String actualURL = contactUsPage.getContactUsPageURL();// Act
        Assert.assertEquals(actualURL, expectedURL,
                "Contact Us URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);// Assert
    }
    @Test(description = "Verify Contact Us page title is correct")
    public void shouldHaveCorrectPageTitle(){
        String expectedTitle ="Contact Us | Naturescape";
        String actualTitle = contactUsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(actualTitle),
                "Contact Us page is incorrect."+
                         "Expected to contain" +expectedTitle+
                         "but got " +actualTitle);
    }
    @Test(description = "Verify Contact Us page loads with correct heading")
    public void shouldLoadContactUsPageWithCorrectHeading() {
        Assert.assertTrue(contactUsPage.isContactUsPageLoaded(),
                "Contact Us page heading should display 'Contact Us'"); // Assert
    }
    @Test(description = "Verify Contact Info button is enabled on page load")
    public void shouldHaveContactInfoButtonEnabled() {
        Assert.assertTrue(contactUsPage.isContactInfoEnabled(),
                "Contact Info button should be enabled on page load"); // Assert
    }
    // ========== ZIP Code Search Tests ==========
    /**
     * Data provider for ZIP code search tests.
     * Format: { zipCode, isValidZip }
     * Valid ZIPs   → expect contact message to appear
     * Invalid ZIPs → expect sorry/not found message to appear
     */
    @DataProvider(name = "zipSearchData")
    public Object[][] zipSearchData() {
        return new Object[][]{
                // ZIP      isValid
                {"60601",  true},   // Chicago, IL — valid
                {"10001",  true},   // New York, NY — valid
                {"90210",  true},   // Beverly Hills, CA — valid
                {"00000",  false},  // Not a real ZIP — invalid
                {"99999",  false},  // Not a real ZIP — invalid
                {"12",     false},  // Too short — invalid
        };
    }
    @Test(
            dataProvider = "zipSearchData",
            description = "Verify ZIP code search shows correct result " +
                    "for valid and invalid ZIPs"
    )
    public void shouldShowCorrectMessageForZipSearch(String zip, boolean isValid) {
        contactUsPage.searchByZip(zip);
        if (isValid) {
            Assert.assertTrue(contactUsPage.isContactMessageDisplayed(),
                    "Contact message should appear for valid ZIP: "
                            + zip);
        } else {
            Assert.assertTrue(contactUsPage.isSorryMessageDisplayed(),
                    "Sorry message should appear for invalid ZIP: "
                            + zip);
        }
    }
    @Test(description = "Verify empty ZIP search shows validation message")
    public void shouldShowValidationMessageForEmptyZip() {
        contactUsPage.searchByZip("");
        String actualMessage = contactUsPage.getContactMessageText();
        Assert.assertTrue(actualMessage.contains("Please enter your zip code"),
                "Validation message should appear for empty ZIP. " +
                        "Actual message: " + actualMessage);
    }
    @Test(description = "Verify valid ZIP shows branch information")
    public void shouldShowBranchInfoForValidZip() {
        String validZip = "60585";
        contactUsPage.searchByZip(validZip);
        Assert.assertTrue(contactUsPage.isBranchInfoDisplayed(),
                "Branch info should appear for valid ZIP: " + validZip);
    }
    @Test(description = "Verify invalid ZIP shows sorry message")
    public void shouldShowSorryMessageForInvalidZip() {
        String invalidZip = "00000";
        contactUsPage.searchByZip(invalidZip);
        Assert.assertTrue(contactUsPage.isSorryMessageDisplayed(),
                "Sorry message should appear for invalid ZIP: "
                        + invalidZip);
    }
    // ========== Navigation Tests ==========
    @Test(description = "Verify clicking branch list navigates to Locations page")
    public void shouldNavigateToLocationsPage() {
        NaturescapeLocationsPage locationsPage = contactUsPage.clickBranchList();
        Assert.assertTrue(locationsPage.isLocationsPageLoaded(),
                "Locations page should load after clicking branch list");
    }
    @Test(description = "Verify clicking career link opens Job Listings page")
    public void shouldNavigateToCareerPage() {
        JobListingsAtNaturescapePage careerPage = contactUsPage.clickCareerLink();
        Assert.assertTrue(careerPage.isCareerPageLoaded(),
                "Job Listings page should load after clicking career link");
    }
    @Test(description = "Verify clicking feedback link opens Survey page")
    public void shouldNavigateToCustomerServiceResponsePage() {
        CustomerServiceResponsePage surveyPage = contactUsPage.clickFeedbackLink();
        Assert.assertTrue(surveyPage.isSurveyPageLoaded(),
                "Survey page should load after clicking feedback link");
    }
    @Test(description = "Verify Contact Us page reloads correctly after refresh")
    public void shouldReturnToHomePageFromContactUsPage(){
        String expectedURL = "https://naturescapelawncare.com/us/contactus/";//Arrange
        contactUsPage.refreshPage();
        Assert.assertEquals(contactUsPage.getContactUsPageURL(),expectedURL,
                "URL should remain the same after is refresh");
        Assert.assertTrue(contactUsPage.isContactUsPageLoaded(),
                "Heading should be still be visil after refrsh");
    }
    @Test(description = "Verify browser back navigates to Home page")
    public void shouldNavigateBackToHomePage(){
        String expectedURL = "https://naturescapelawncare.com/";
        contactUsPage.goBack();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL,
                "Should navigate to HomePage." +
                         "Expected:" + expectedURL+
                         "but got: " + driver.getCurrentUrl());
    }
}