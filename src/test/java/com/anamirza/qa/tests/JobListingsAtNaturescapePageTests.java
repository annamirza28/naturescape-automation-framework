package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.ContactUsPage;
import com.anamirza.qa.pages.JobListingsAtNaturescapePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Test suite for the Naturescape Job Listings Page.
 * URL: <a href="https://naturescapelawncare.applicantpro.com/jobs/">Job Listings</a>
 * Verifies:
 * - Correct URL and title
 * - Page heading displayed correctly
 * - All search filters displayed
 * - Navigation links displayed
 * - Page accessible from Contact Us page
 */
public class JobListingsAtNaturescapePageTests extends BaseTest {
    private JobListingsAtNaturescapePage jobListingsPage;

    // ========== Setup ==========

    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.applicantpro.com/jobs/");
        jobListingsPage = new JobListingsAtNaturescapePage(driver);
    }

    // ========== URL & Title Tests ==========

    @Test(description = "Verify Job Listings page URL is correct")
    public void shouldNavigateToJobListingsPageWithCorrectURL() {
        String expectedURL = "naturescapelawncare.applicantpro.com/jobs/";
        String actualURL = jobListingsPage.getPageURL();
        Assert.assertTrue(actualURL.contains(expectedURL),
                "Job Listings URL is incorrect. " +
                        "Expected to contain: " + expectedURL +
                        " but got: " + actualURL);
    }

    @Test(description = "Verify Job Listings page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "Job Listings";
        String actualTitle = jobListingsPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Job Listings title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle);
    }

    // ========== Page Load Tests ==========

    @Test(description = "Verify Job Listings heading is displayed")
    public void shouldDisplayHeadingOnJobListingsPage() {
        Assert.assertTrue(jobListingsPage.isCareerPageLoaded(),
                "Heading should be displayed on Job Listings page");
    }

    @Test(description = "Verify Job Listings heading text is correct")
    public void shouldDisplayCorrectHeadingText() {
        String expected = "Current Job Listings";
        String actual = jobListingsPage.getHeadingText();
        Assert.assertEquals(actual, expected,
                "Job Listings heading text is incorrect. " +
                        "Expected: " + expected +
                        " but got: " + actual);
    }

    // ========== Search Section Tests ==========

    @Test(description = "Verify search input is displayed")
    public void shouldDisplaySearchInput() {
        Assert.assertTrue(jobListingsPage.isSearchInputDisplayed(),
                "Search input should be displayed");
    }

    @Test(description = "Verify City dropdown is displayed")
    public void shouldDisplayCityDropdown() {
        Assert.assertTrue(jobListingsPage.isCityDropdownDisplayed(),
                "City dropdown should be displayed");
    }

    @Test(description = "Verify State dropdown is displayed")
    public void shouldDisplayStateDropdown() {
        Assert.assertTrue(jobListingsPage.isStateDropdownDisplayed(),
                "State dropdown should be displayed");
    }

    @Test(description = "Verify Employment Type dropdown is displayed")
    public void shouldDisplayEmploymentTypeDropdown() {
        Assert.assertTrue(jobListingsPage.isEmploymentTypeDropdownDisplayed(),
                "Employment Type dropdown should be displayed");
    }

    @Test(description = "Verify Pay Frequency dropdown is displayed")
    public void shouldDisplayPayFrequencyDropdown() {
        Assert.assertTrue(jobListingsPage.isPayFrequencyDropdownDisplayed(),
                "Pay Frequency dropdown should be displayed");
    }

    // ========== Navigation Links Tests ==========

    @Test(description = "Verify Jobs link is displayed")
    public void shouldDisplayJobsLink() {
        Assert.assertTrue(jobListingsPage.isJobsLinkDisplayed(),
                "Jobs link should be displayed");
    }

    @Test(description = "Verify Login link is displayed")
    public void shouldDisplayLoginLink() {
        Assert.assertTrue(jobListingsPage.isLoginLinkDisplayed(),
                "Login link should be displayed");
    }

    // ========== Navigation Tests ==========

    @Test(description = "Verify Job Listings accessible from Contact Us")
    public void shouldNavigateToJobListingsFromContactUs() {
        driver.get("https://naturescapelawncare.com/us/contactus/");
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        JobListingsAtNaturescapePage careerPage = contactUsPage.clickCareerLink();
        Assert.assertTrue(careerPage.isCareerPageLoaded(),
                "Job Listings page should load from " +
                        "Contact Us career link");
    }
}
