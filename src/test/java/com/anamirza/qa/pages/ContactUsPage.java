package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object for the Naturescape Contact Us Page.
 * URL: https://naturescapelawncare.com/us/contactus/
 * Handles:
 * - ZIP code search for local branch info
 * - Navigation to Locations, Career, and Survey pages
 */
public class ContactUsPage {
    private final WebDriver driver;
    private final WindowManager windowManager;
    // ========== Locators ==========
    private final By header =
            By.xpath("//h1[normalize-space()='Contact Us']");
    private final By zipCode =
            By.id("zip");
    private final By contactInfoBtn =
            By.xpath("//input[@value='Contact Info']");
    private final By contactMessage =
            By.cssSelector(".exc1");
    private final By sorryMessage =
            By.id("sorry");
    private final By branchInfoHeader =
            By.xpath("//h5[text()='Local Branch Information:']");
    private final By hereBranchList =
            By.xpath("//a[@href='/locations/']");
    private final By hereCareerOpportunity =
            By.xpath("//a[contains(@href,'applicantpro')]");
    private final By feedbackLink =
            By.linkText("Customer Satisfaction Survey");
    // ========== Constructor ==========
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    // ========== Page Validation ==========
    /**
     * Returns the current page URL.
     */
    public String getContactUsPageURL() {
        return driver.getCurrentUrl();
    }
    /**
     * Verifies the Contact Us page is loaded by checking the heading text.
     */
    public boolean isContactUsPageLoaded() {
        return WaitUtil.waitForVisibility(header).getText().trim().equals("Contact Us");
    }
    // ========== Actions ==========
    /**
     * Clears the ZIP code field and enters the given ZIP.
     */
    public void enterZipCode(String zip) {
        WebElement field = WaitUtil.waitForVisibility(zipCode);
        field.clear();
        field.sendKeys(zip);
    }
    /**
     * Checks if the Contact Info button is enabled.
     */
    public boolean isContactInfoEnabled() {
        return WaitUtil.waitForVisibility(contactInfoBtn).isEnabled();
    }
    /**
     * Clicks the Contact Info button to trigger ZIP search.
     */
    public void clickContactInfo() {
        WaitUtil.waitForClickable(contactInfoBtn).click();
    }
    /**
     * Enters a ZIP code and clicks Contact Info button.
     * Combines enterZipCode() and clickContactInfo().
     */
    public void searchByZip(String zip) {
        enterZipCode(zip);
        clickContactInfo();
    }
    // ========== Validations ==========
    /**
     * Checks if the contact result message is displayed.
     */
    public boolean isContactMessageDisplayed() {
        return WaitUtil.waitForVisibility(contactMessage).isDisplayed();
    }
    /**
     * Returns the text of the contact result message.
     */
    public String getContactMessageText() {
        return WaitUtil.waitForVisibility(contactMessage).getText();
    }
    /**
     * Returns the text of the sorry/not found message.
     */
    public String getSorryMessageText() {
        return WaitUtil.waitForVisibility(sorryMessage).getText();
    }
    /**
     * Checks if the sorry/not found message is displayed.
     */
    public boolean isSorryMessageDisplayed() {
        return WaitUtil.waitForVisibility(sorryMessage).isDisplayed();
    }
    /**
     * Checks if the local branch information header is displayed.
     */
    public boolean isBranchInfoDisplayed() {
        return WaitUtil.waitForVisibility(branchInfoHeader).isDisplayed();
    }
    // ========== Navigation ==========
    /**
     * Clicks the branch list link — opens in same tab.
     */
    public NaturescapeLocationsPage clickBranchList() {
        WaitUtil.waitForClickable(hereBranchList).click();
        return new NaturescapeLocationsPage(driver);
    }
    /**
     * Clicks the career opportunity link — navigates in same tab.
     * Note: originally expected new tab; confirmed same-tab behavior
     * via debug testing (2026).
     */
    public JobListingsAtNaturescapePage clickCareerLink() {
        WaitUtil.waitForClickable(hereCareerOpportunity).click();
        return new JobListingsAtNaturescapePage(driver);
    }
    /**
     * Clicks the Customer Satisfaction Survey link — opens in new tab.
     * Waits for new tab then switches to it.
     */
    public CustomerServiceResponsePage clickFeedbackLink() {
        String originalWindow = driver.getWindowHandle();
        int currentWindowCount = driver.getWindowHandles().size();
        WaitUtil.waitForClickable(feedbackLink).click();
        WaitUtil.waitForNewWindowToOpen(currentWindowCount);
        windowManager.switchToNewTab(originalWindow);
        return new CustomerServiceResponsePage(driver);
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /**
     * Refreshes the Contact Us page.
     * Used to verify the page reloads correctly.
     */
    public void refreshPage(){
        windowManager.refreshPage();
    }
    /**
     * Navigates back to the previous page (Home page).
     * Used to verify browser back navigation works.
     */
    public void goBack(){
        windowManager.goBack();
    }
}