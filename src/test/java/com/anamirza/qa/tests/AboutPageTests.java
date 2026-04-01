package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.AboutPage;
import com.anamirza.qa.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * Test suite for the Naturescape About Page.
 * URL: <a href="https://naturescapelawncare.com/us/about/">About Page</a>
 * Verifies:
 * - Correct URL after navigation
 * - Page title is correct
 * - Page heading is displayed with correct text
 * - Page refresh works correctly
 * - Browser back navigation works
 */
public class AboutPageTests extends BaseTest {
    private HomePage homePage;
    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        // BaseTest.setUp() already opened the browser and
        // navigated to base URL — we just initialize the page object
        homePage = new HomePage(driver);
    }
    // ========== URL Tests ==========
    @Test(description = "Verify About page URL is correct after navigation")
    public void shouldNavigateToAboutPageWithCorrectURL() {
        String expectedURL = "https://naturescapelawncare.com/us/about/"; // Arrange
        AboutPage aboutPage = homePage.clickAboutPage();// Act
        String actualURL = aboutPage.getAboutPageURL();
        Assert.assertEquals(actualURL, expectedURL,
                "About page URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);  // Assert
    }
    // ========== Title Tests ==========
    @Test(description = "Verify About page title is correct")
    public void shouldHaveCorrectPageTitle() {
        String expectedTitle = "About | Naturescape";// Arrange
        AboutPage aboutPage = homePage.clickAboutPage(); // Act
        String actualTitle = aboutPage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "About page title is incorrect. " +
                        "Expected to contain: " + expectedTitle +
                        " but got: " + actualTitle); // Assert
    }
    // ========== Heading Tests ==========
    @Test(description = "Verify About page heading is visible")
    public void shouldDisplayHeadingOnAboutPage() {
        AboutPage aboutPage = homePage.clickAboutPage(); // Act
        Assert.assertTrue(aboutPage.isHeadingDisplayed(),
                "Heading should be visible on the About page");// Assert
    }
    @Test(description = "Verify About page heading contains correct text")
    public void shouldDisplayCorrectHeadingTextOnAboutPage() {
        AboutPage aboutPage = homePage.clickAboutPage();// Act
        String actualHeading = aboutPage.getHeadingText();
        Assert.assertTrue(actualHeading.contains("Commitments To You"),
                "About page heading text is incorrect. " +
                        "Expected to contain: 'Commitments To You'" +
                        " but got: " + actualHeading); // Assert
    }
    // ========== Navigation Tests ==========
    @Test(description = "Verify browser back navigation returns to Home page")
    public void shouldNavigateBackToHomePageFromAboutPage(){
        String expectedHomeURL = "https://naturescapelawncare.com/";//Arrange
        AboutPage aboutPage= homePage.clickAboutPage();// Act
        aboutPage.goBack();
        Assert.assertEquals(driver.getCurrentUrl(), expectedHomeURL,
                "Should navigate to Home Page"+
                         "Expected:"+ expectedHomeURL +
                        "but we got:" +driver.getCurrentUrl());//Assert
    }
    @Test(description="Verify About page will refresh the page")
    public void shouldRefreshPage(){
        String expectedURL = "https://naturescapelawncare.com/us/about/";
        AboutPage aboutPage = homePage.clickAboutPage();
        aboutPage.refreshPage();
        Assert.assertEquals(aboutPage.getAboutPageURL(),expectedURL,
                "URL should remain correct after page is refreshed"+
                        "Expected:" + expectedURL+
                        "but we got:" + aboutPage.getAboutPageURL());
    }

}

