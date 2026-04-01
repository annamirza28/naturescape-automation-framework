package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.ContactUsPage;
import com.anamirza.qa.pages.NaturescapeLocationsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Locations Page.
 * URL: <a href="https://naturescapelawncare.com/locations/">Locations Page</a>
 * Verifies:
 * - Correct URL and title after navigation
 * - Page heading displayed correctly
 * - State sections are displayed
 * - Scroll behavior works correctly
 * - Page accessible from Contact Us page
 */
public class NaturescapeLocationsPageTests extends BaseTest {

    private NaturescapeLocationsPage locationsPage;

    // ========== Setup ==========

    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/locations/");
        locationsPage = new NaturescapeLocationsPage(driver);
    }

    // ========== URL & Title Tests ==========

    @Test(description = "Verify Locations page URL is correct")
    public void shouldNavigateToLocationsPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/locations/";
        String actualURL = locationsPage.getPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "Locations page URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }

    @Test(description = "Verify Locations page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Locations | Naturescape";
        String actualTitle = locationsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Locations page title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }

    // ========== Page Load Tests ==========

    @Test(description = "Verify Locations page heading is displayed")
    public void shouldDisplayHeadingOnLocationsPage() {
        Assert.assertTrue(locationsPage.isLocationsPageLoaded(),
                "Heading should be displayed on Locations page");
    }

    @Test(description = "Verify Locations page heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expectedText = "Locations";
        String actualText = locationsPage.getHeadingText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Locations heading text is incorrect. " +
                        "Expected to contain: " + expectedText +
                        " but got: " + actualText);
    }

    // ========== State Section Tests ==========

    @Test(description = "Verify Georgia section is displayed")
    public void shouldDisplayGeorgiaSection() {
        Assert.assertTrue(locationsPage.isGeorgiaSectionDisplayed(),
                "Georgia section should be displayed");
    }

    @Test(description = "Verify Indiana section is displayed")
    public void shouldDisplayIndianaSection() {
        Assert.assertTrue(locationsPage.isIndianaSectionDisplayed(),
                "Indiana section should be displayed");
    }

    @Test(description = "Verify Illinois section is displayed")
    public void shouldDisplayIllinoisSection() {
        Assert.assertTrue(locationsPage.isIlloisSectionDisplayed(),
                "Illinois section should be displayed");
    }

    @Test(description = "Verify Wisconsin section is displayed")
    public void shouldDisplayWisconsinSection() {
        Assert.assertTrue(locationsPage.isWisconsinSectionDisplayed(),
                "Wisconsin section should be displayed");
    }

    // ========== Scroll Tests ==========

    @Test(description = "Verify page can scroll to Terms and Privacy link")
    public void shouldScrollToTermsAndPrivacyLink() {
        locationsPage.scrollToTermsAndPrivacy();
        Assert.assertTrue(locationsPage.isLocationsPageLoaded(),
                "Page should still be loaded after scrolling");
    }

    // ========== Refresh & Navigation Tests ==========

    @Test(description = "Verify Locations page reloads correctly after refresh")
    public void shouldRefreshLocationsPage() {
        String expectedURL = "https://naturescapelawncare.com/locations/";
        locationsPage.refreshPage();
        Assert.assertEquals(locationsPage.getPageURL(), expectedURL,
                "URL should remain correct after refresh");
        Assert.assertTrue(locationsPage.isLocationsPageLoaded(),
                "Heading should still be visible after refresh");
    }

    @Test(description = "Verify Locations accessible from Contact Us page")
    public void shouldNavigateToLocationsFromContactUs() {
        driver.get("https://naturescapelawncare.com/us/contactus/");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        NaturescapeLocationsPage page = contactUsPage.clickBranchList();
        Assert.assertTrue(page.isLocationsPageLoaded(),
                "Locations page should load from Contact Us " +
                        "branch list link");
    }
}