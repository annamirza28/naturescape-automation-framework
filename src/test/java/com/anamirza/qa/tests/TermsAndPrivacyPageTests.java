package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.TermsAndPrivacyPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Terms and Privacy Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/policies/">Terms and Privacy</a>
 * Verifies:
 * - Correct URL after navigation
 * - Page heading is displayed with correct text
 * - Page refresh works correctly
 * - Back navigation works correctly
 */

public class TermsAndPrivacyPageTests extends BaseTest {
    private TermsAndPrivacyPage termsAndPrivacyPage;

    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/about/policies/");
        termsAndPrivacyPage = new TermsAndPrivacyPage(driver);
    }
    // ========== URL & Title Tests ==========

    @Test(description = "Verify Terms and Privacy page URL is correct")
    public void shouldNavigateToTermsAndPrivacyPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/about/policies/";
        String actualURL = termsAndPrivacyPage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "Terms and Privacy URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }

    @Test(description = "Verify Terms and Privacy page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "About | Naturescape";
        String actualTitle = termsAndPrivacyPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Terms and Privacy page title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }
    // ========== Page Load Tests ==========
    @Test(description = "Verify Terms of Use heading is displayed")
    public void shouldDisplayTermsOfUseHeading() {
        Assert.assertTrue(termsAndPrivacyPage.isPageLoaded(),
                "Terms of Use heading should be displayed");
    }
    @Test(description = "Verify Terms of Use heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expectedHeading = "Terms of Use";
        String actualHeading = termsAndPrivacyPage.getHeadingText();
        Assert.assertEquals(actualHeading, expectedHeading,
                "Heading text is incorrect. " +
                        "Expected: " + expectedHeading +
                        " but got: " + actualHeading);
    }
    // ========== Refresh & Navigation Tests ==========
    @Test(description = "Verify page reloads correctly after refresh")
    public void shouldRefreshTermsAndPrivacyPage() {
        String expectedURL = "https://naturescapelawncare.com/us/about/policies/";
        termsAndPrivacyPage.refreshPage();
        Assert.assertEquals(termsAndPrivacyPage.getPageURL(), expectedURL,
                "URL should remain correct after refresh");
        Assert.assertTrue(termsAndPrivacyPage.isPageLoaded(),
                "Heading should still be visible after refresh");
    }

    @Test(description = "Verify back navigation works from Terms page")
    public void shouldNavigateBackFromTermsPage() {
        termsAndPrivacyPage.goBack();
        Assert.assertTrue(driver.getCurrentUrl().contains("naturescapelawncare.com"),
                "Should navigate back to Naturescape site");
    }

}
