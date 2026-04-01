package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Home Page.
 * URL: <a href="https://naturescapelawncare.com/">Home Page</a>
 * Verifies:
 * - Correct URL and title
 * - Page headings displayed correctly
 * - All navigation links work correctly
 * - New tab links open correct pages
 */
public class HomePageTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setUpPage(){
        homePage = new HomePage(driver);
    }
    // ========== URL & Title Tests ==========
    @Test(description = "Verify Home page URL is correct")
    public void shouldHaveCorrectHomePageURL(){
        String expectedURL = "https://naturescapelawncare.com/";
        String actualURL = homePage.getHomePageURL();
        Assert.assertTrue(actualURL.contains(expectedURL),"Home Page is incorrect."+
                                                                   "Expected:" + expectedURL+
                                                                   "but got:" + actualURL);
    }
    @Test(description = "Verify Home page title is correct")
    public void shouldHaveCorrectPageTitle(){
        String expectedTitle = "Home | Naturescape";
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),
                "Home Page Title is incorrect."+
                        "Expected:" + expectedTitle+
                        "but got:" + actualTitle);
    }
    // ========== Page Load Tests ==========
    @Test(description = "Verify H1 heading is displayed on Home page")
    public void shouldDisplayPageHeading(){
        Assert.assertTrue(homePage.isPageHeadingDisplayed(),
                "H1 heading should be displayed on Home page");
    }
    @Test(description = "Verify H1 heading text is correct")
    public void shouldDisplayCorrectPageHeading(){
       String expectedHeading = "Welcome to Naturescape";
       String actualHeading = homePage.getPageHeadingText();
       Assert.assertTrue(actualHeading.contains(expectedHeading),
               "H1 heading text is incorrect. " +
                        "Expected to contain: " + expectedHeading +
                        "but got: " + actualHeading);
    }
    @Test(description = "Verify Welcome heading is displayed")
    public void shouldDisplayWelcomeHeading() {
        Assert.assertTrue(homePage.isWelcomeHeadingDisplayed(),
                "Welcome heading should be displayed on Home page");
    }
    @Test(description = "Verify Welcome heading text is correct")
    public void shouldDisplayCorrectWelcomeHeadingText() {
        String expectedText = "Welcome to Naturescape";
        String actualText = homePage.getWelcomeHeadingText();
        Assert.assertTrue(actualText.contains(expectedText),
                "Welcome heading text is incorrect. " +
                        "Expected to contain: " + expectedText +
                        " but got: " + actualText);
    }
    @Test(description = "Verify Sign Up heading is displayed")
    public void shouldDisplaySignUpHeading() {
        Assert.assertTrue(homePage.isSignUpHeadingDisplayed(),
                "Sign Up heading should be displayed on Home page");
    }
    // ========== Navigation Tests — Same Tab ==========
    @Test(description = "Verify GET STARTED nav link navigates correctly")
    public void shouldNavigateToGetStartedPage() {
        GetStartedPage page = homePage.clickGetStarted();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Get Started page should load after clicking " +
                        "GET STARTED");
    }
    @Test(description = "Verify ABOUT nav link navigates correctly")
    public void shouldNavigateToAboutPage() {
        AboutPage page = homePage.clickAboutPage();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "About page should load after clicking ABOUT");
    }
    @Test(description = "Verify SERVICES nav link navigates correctly")
    public void shouldNavigateToServicesPage() {
        ServicesPage page = homePage.clickServicesPage();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Services page should load after clicking SERVICES");
    }
    @Test(description = "Verify LAWN TIPS nav link navigates correctly")
    public void shouldNavigateToLawnTipsPage() {
        LawnTipsPage page = homePage.clickLawnTipsPage();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Lawn Tips page should load after clicking LAWN TIPS");
    }
    @Test(description = "Verify MY ACCOUNT nav link navigates correctly")
    public void shouldNavigateToMyAccountPage() {
        MyAccountPage page = homePage.clickMyAccountPage();
        Assert.assertTrue(page.isPageHeadingDisplayed(),
                "My Account page should load after clicking MY ACCOUNT");
    }
    @Test(description = "Verify CONTACT US nav link navigates correctly")
    public void shouldNavigateToContactUsPage() {
        ContactUsPage page = homePage.clickContactUsPage();
        Assert.assertTrue(page.isContactUsPageLoaded(),
                "Contact Us page should load after clicking CONTACT US");
    }
    @Test(description = "Verify 40 locations link navigates correctly")
    public void shouldNavigateTo40LocationsPage() {
        NaturescapeLocationsPage page = homePage.click40Locations();
        Assert.assertTrue(page.isLocationsPageLoaded(),
                "Locations page should load after clicking 40 locations");
    }
    @Test(description = "Verify sign up for new services link navigates correctly")
    public void shouldNavigateToSignUpForNewServicesPage() {
        GetStartedPage page = homePage.clickSignUpForNewServices();
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Get Started page should load after clicking " +
                         "sign up for new services");
    }
    @Test(description = "Verify Career here link opens Job Listings page")
    public void shouldNavigateToJobListingsPage() {
        JobListingsAtNaturescapePage page = homePage.clickHere();
        Assert.assertTrue(page.isCareerPageLoaded(),
                "Job Listings page should load after clicking here");
    }
    @Test(description = "Verify Customer Satisfaction Survey opens Survey page")
    public void shouldNavigateToCustomerSatisfactionSurveyPage() {
        CustomerServiceResponsePage page = homePage.clickCustomerSatisfactionSurvey();
        Assert.assertTrue(page.isSurveyPageLoaded(),
                "Survey page should load after clicking " +
                        "Customer Satisfaction Survey");
    }
    @Test(description = "Verify pay your bills link navigates to Payment page")
    public void shouldNavigateToPaymentPageViaPayYourBills() {
        // Act
        PaymentPage page = homePage.clickPayYourBills();
        // Assert
        Assert.assertTrue(page.isHeadingDisplayed(),
                "Payment page should load after clicking pay your bills");
    }
    @Test(description = "Verify Terms and Privacy link navigates correctly")
    public void shouldNavigateToTermsAndPrivacyPage() {
        // Act — clickTermsAndPrivacy() already scrolls internally
        TermsAndPrivacyPage page = homePage.clickTermsAndPrivacy();
        // Assert
        Assert.assertTrue(page.isTermsPageLoaded(),
                "Terms page should load after clicking Terms & Privacy");
    }
}
