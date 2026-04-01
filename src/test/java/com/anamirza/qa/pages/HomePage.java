package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Page Object for the Naturescape Home Page.
 * URL: <a href="https://naturescapelawncare.com/">Home Page</a>
 * Handles all navigation from the home page:
 * - Nav bar links (same tab)
 * - Inline content links (same tab)
 * - New tab links (Career, Customer Satisfaction Survey)
 */
public class HomePage {
    private final WebDriver driver;
    private final WindowManager windowManager;

    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[contains(.,'Welcome to Naturescape')]");
    private final By signUpHeading =
            By.xpath("//h1[contains(.,'Sign Up and Pay Online')]");
    private final By locationsLink =
            By.linkText("40 locations");
    private final By signUpForNewServicesLink =
            By.linkText("sign up for new services");
    private final By payYourBillsLink =
            By.linkText("pay your bills");
    private final By termsAndPrivacyLink =
            By.linkText("Terms & Privacy");
    // ========== Constructor ==========
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    // ========== Private Helper ==========
    /**
     * Finds a link by its exact visible text and clicks via JavaScript.
     * JS click handles cases where elements are overlapped
     * by headers or banners that intercept normal Selenium clicks.
     * @param linkText exact visible text of the link
     */
    private void clickLink(String linkText) {
        By locator = By.linkText(linkText);
        WebElement element = WaitUtil.waitForClickable(locator);
        JavaScriptUtil.click(element);
    }
    // ========== Page Validation ==========
    /** Returns the current page URL. */
    public String getHomePageURL() {
        return driver.getCurrentUrl();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /** Checks if the Welcome H1 heading is displayed. */
    public boolean isPageHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /** Returns the Welcome H1 heading text. */
    public String getPageHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }
    /**
     * Checks if the Welcome heading is displayed.
     * Same as isPageHeadingDisplayed() — both check the H1.
     */
    public boolean isWelcomeHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /**
     * Returns the Welcome heading text.
     * Same as getPageHeadingText() — both read the H1.
     */
    public String getWelcomeHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }
    /**
     * Checks if Sign Up and Pay Online heading is displayed.
     * Note: requires scrolling down to be visible.
     */
    public boolean isSignUpHeadingDisplayed() {
        return WaitUtil.waitForVisibility(signUpHeading).isDisplayed();
    }
    // ========== Navigation — Same Tab ==========
    /**
     * Clicks GET STARTED nav link.
     * Navigates to Get Started page in same tab.
     */
    public GetStartedPage clickGetStarted() {
        clickLink("GET STARTED");
        return new GetStartedPage(driver);
    }
    /**
     * Clicks ABOUT nav link.
     * Navigates to About page in same tab.
     */
    public AboutPage clickAboutPage() {
        clickLink("ABOUT");
        return new AboutPage(driver);
    }
    /**
     * Clicks SERVICES nav link.
     * Navigates to Services page in same tab.
     */
    public ServicesPage clickServicesPage() {
        clickLink("SERVICES");
        return new ServicesPage(driver);
    }
    /**
     * Clicks LAWN TIPS nav link.
     * Navigates to Lawn Tips page in same tab.
     */
    public LawnTipsPage clickLawnTipsPage() {
        clickLink("LAWN TIPS");
        return new LawnTipsPage(driver);
    }
    /**
     * Clicks MY ACCOUNT nav link.
     * Navigates to My Account page in same tab.
     */
    public MyAccountPage clickMyAccountPage() {
        clickLink("MY ACCOUNT");
        return new MyAccountPage(driver);
    }
    /**
     * Clicks CONTACT US nav link.
     * Navigates to Contact Us page in same tab.
     */
    public ContactUsPage clickContactUsPage() {
        clickLink("CONTACT US");
        return new ContactUsPage(driver);
    }
    /**
     * Clicks the "40 locations" inline link.
     * Navigates to Locations page in same tab.
     */
    public NaturescapeLocationsPage click40Locations() {
        WaitUtil.waitForClickable(locationsLink).click();
        return new NaturescapeLocationsPage(driver);
    }
    /**
     * Clicks "sign up for new services" inline link.
     * Navigates to Get Started page in same tab.
     */
    public GetStartedPage clickSignUpForNewServices() {
        WaitUtil.waitForClickable(signUpForNewServicesLink).click();
        return new GetStartedPage(driver);
    }
    /**
     * Clicks "pay your bills" inline link.
     * Navigates to Payment page in same tab.
     */
    public PaymentPage clickPayYourBills() {
        WaitUtil.waitForClickable(payYourBillsLink).click();
        return new PaymentPage(driver);
    }
    /**
     * Clicks "Terms & Privacy" footer link.
     * Navigates to Terms and Conditions page in same tab.
     */
    public TermsAndPrivacyPage clickTermsAndPrivacy() {
        JavaScriptUtil.scrollToBottom();
        WaitUtil.waitForClickable(termsAndPrivacyLink).click();
        return new TermsAndPrivacyPage(driver);
    }

    //Navigation — opens in new tab ==========
    /**
     * Clicks the "here" career link — navigates in same tab.
     * Note: originally expected new tab; confirmed same-tab
     * behavior via debug testing (2026).
     */
    public JobListingsAtNaturescapePage clickHere() {
        clickLink("here");
        return new JobListingsAtNaturescapePage(driver);
    }
    /**
     * Clicks "Customer Satisfaction Survey" link which opens in a new tab.
     * Waits for new tab to open, switches to it, returns the page object.
     */
    public CustomerServiceResponsePage clickCustomerSatisfactionSurvey() {
        String originalWindow = driver.getWindowHandle();
        int currentCount = driver.getWindowHandles().size();
        clickLink("Customer Satisfaction Survey");
        WaitUtil.waitForNewWindowToOpen(currentCount);
        windowManager.switchToNewTab(originalWindow);
        return new CustomerServiceResponsePage(driver);
    }

}