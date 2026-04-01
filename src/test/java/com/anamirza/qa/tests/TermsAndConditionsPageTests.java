package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.TermsAndConditionsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Terms and Conditions Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/survey-terms/">Terms Page</a>
 * Verifies:
 * - Correct URL after navigation
 * - Page heading is displayed
 * - Page heading text is correct
 */
public class TermsAndConditionsPageTests extends BaseTest {
    private TermsAndConditionsPage termsAndConditionsPage;
    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage(){
        driver.get("https://naturescapelawncare.com/us/about/survey-terms/");
        termsAndConditionsPage = new TermsAndConditionsPage(driver);
    }
    // ========== URL & Page Load Tests ==========
    @Test(description="Verify Terms and Conditions page URL is correct")
    public void shouldNavigateToTermsPageWithCorrectURL(){
        String expectedURL ="https://naturescapelawncare.com/us/about/survey-terms/";
        String actualURL = termsAndConditionsPage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,"Terms page URL is incorrect. " +
                "Expected: " + expectedURL +
                " but got: " + actualURL );
    }
    @Test(description = "Verify Terms and Conditions page heading is displayed")
    public void shouldDisplayHeadingOnTermsPage() {
        // Assert
        Assert.assertTrue(termsAndConditionsPage.isTermsPageLoaded(),
                "Heading should be displayed on Terms and Conditions page");
    }
    @Test(description= "Verify Terms and Conditions page heading is displayed")
    public void shouldDisplayCorrectHeadingTextOnTermsPage(){
        String expected = "Terms and Conditions";
        String actual = termsAndConditionsPage.getHeadingText();
        Assert.assertTrue(actual.contains(expected),
                "Terms page heading text is incorrect. " +
                        "Expected to contain: " + expected +
                        " but got: " + actual);
    }
    }



