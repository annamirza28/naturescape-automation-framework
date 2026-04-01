package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.CustomerServiceResponsePage;
import com.anamirza.qa.pages.TermsAndConditionsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Test suite for the Customer Service Response Page.
 * URL: <a href="https://sg.naturescapelawncare.com/s3/Customer-Service-Response">Survey Page</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading is displayed with correct text
 * - Survey subheading is displayed
 * - All form fields are displayed
 * - Page refresh works correctly
 * - Terms and Conditions link opens correct page
 */
public class CustomerServiceResponsePageTests extends BaseTest {
    private CustomerServiceResponsePage surveyPage;
    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        driver.get("https://sg.naturescapelawncare.com" +
                "/s3/Customer-Service-Response");
        surveyPage = new CustomerServiceResponsePage(driver);
    }
    // ========== URL & Page Load Tests ==========
    @Test(description= "Verify page URL is correct after navigation")
    public void shouldNavigateToSurveyPageWithCorrectURL(){
        String expectedURL = "https://sg.naturescapelawncare.com/s3/Customer-Service-Response";
        String actualURL = surveyPage.getSurveyPageURL();
        Assert.assertEquals(actualURL,expectedURL,
                "Survey Page is correct" +
                        "Expected" + expectedURL +
                        "but got" + actualURL);
    }
    @Test(description = "Verify main heading is displayed on Survey page")
    public void shouldDisplayMainHeadingOnSurveyPage() {
        // Assert
        Assert.assertTrue(surveyPage.isSurveyPageLoaded(),
                "Main heading should be displayed on Survey page");
    }

    @Test(description = "Verify main heading text is correct")
    public void shouldDisplayCorrectMainHeadingText() {
        String expected = "Customer Service Response";
        String actual = surveyPage.getPageHeadingText();
        Assert.assertEquals(actual, expected,
                "Main heading text is incorrect. " +
                        "Expected: " + expected +
                        " but got: " + actual);
    }

    @Test(description = "Verify Survey subheading is displayed")
    public void shouldDisplaySurveySubheading() {
        String expectedSubheading = "Survey";
        String actual = surveyPage.getSurveySubheadingText();
        Assert.assertTrue(actual.contains(expectedSubheading),
                "Survey subheading should contain 'Survey'. " +
                        "Actual: " + actual);
    }

    // ========== Form Field Tests ==========

    @Test(description = "Verify property number field is displayed")
    public void shouldDisplayPropertyNumberField() {
        Assert.assertTrue(surveyPage.isPropertyNumberFieldDisplayed(),
                "Property number field should be displayed");
    }

    @Test(description = "Verify billing zip code field is displayed")
    public void shouldDisplayBillingZipCodeField() {
        Assert.assertTrue(surveyPage.isBillingZipCodeFieldDisplayed(),
                "Billing zip code field should be displayed");
    }

    @Test(description = "Verify email address field is displayed")
    public void shouldDisplayEmailField() {
        Assert.assertTrue(surveyPage.isEmailFieldDisplayed(),
                "Email address field should be displayed");
    }
    // ========== Refresh Tests ==========

    @Test(description = "Verify Survey page reloads correctly after refresh")
    public void shouldRefreshSurveyPage(){
        String expectedURL = "https://sg.naturescapelawncare.com" +
                "/s3/Customer-Service-Response";
        surveyPage.refreshPage();
        Assert.assertEquals(surveyPage.getSurveyPageURL(), expectedURL,
                "URL should remain correct after refresh");
        Assert.assertTrue(surveyPage.isSurveyPageLoaded(),
                "Heading should still be visible after refresh");
    }

    // ========== Navigation Tests ==========

    @Test(description = "Verify Terms and Conditions link opens correct page")
    public void shouldNavigateToTermsAndConditionsPage() {
        TermsAndConditionsPage termsAndConditionsPage = surveyPage.clickTermsAndConditions();
        Assert.assertTrue(termsAndConditionsPage.isTermsPageLoaded(),
                "Terms and Conditions page should load");
        Assert.assertEquals(termsAndConditionsPage.getPageURL(),
                "https://naturescapelawncare.com/us/about/survey-terms/",
                "Terms and Conditions URL is incorrect");
    }
}


