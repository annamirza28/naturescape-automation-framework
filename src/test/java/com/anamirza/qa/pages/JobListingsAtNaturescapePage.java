package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape Job Listings Page.
 * URL: <a href="https://naturescapelawncare.applicantpro.com/jobs/">Job Listings</a>
 * Navigated to from Contact Us and Home page career links.
 * Note: navigates in same tab — confirmed via debug testing (2026).
 */

public class JobListingsAtNaturescapePage {
    private final WebDriver driver;
    private final By jobListingsHeader =
            By.xpath("//h1[contains(.,'Current Job Listings')]");
    private final By searchJobsInput = By.id("keywords");
    private final By cityDropdown =
            By.xpath("//div[@class='w-select__selection'" +
                    " and text()='City']");
    private final By stateDropdown =
            By.xpath("//div[@class='w-select__selection'" +
                    " and text()='State']");
    private final By employmentTypeDropdown =
            By.xpath("//div[@class='w-select__selection'" +
                    " and text()='Employment Type']");
    private final By payFrequencyDropdown =
            By.xpath("//div[@class='w-select__selection'" +
                    " and text()='Pay Frequency']");
    private final By jobsLink =
            By.xpath("//a[@href='/jobmap/']");
    private final By loginLink =
            By.xpath("//a[@title='Login to Your Account']");

    public JobListingsAtNaturescapePage(WebDriver driver) {
        this.driver = driver;
    }
    /** Returns the current page URL. */
    public String getPageURL() {
        return driver.getCurrentUrl();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }

    /** Verifies the page is loaded by checking the heading. */
    public boolean isCareerPageLoaded() {
        return WaitUtil.waitForVisibility(jobListingsHeader)
                .isDisplayed();
    }

    /** Returns the page heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(jobListingsHeader)
                .getText().trim();
    }

    // ========== Search Section Validation ==========

    /** Checks if search input is displayed. */
    public boolean isSearchInputDisplayed() {
        return WaitUtil.waitForVisibility(searchJobsInput)
                .isDisplayed();
    }

    /** Checks if City dropdown is displayed. */
    public boolean isCityDropdownDisplayed() {
        return WaitUtil.waitForVisibility(cityDropdown).isDisplayed();
    }

    /** Checks if State dropdown is displayed. */
    public boolean isStateDropdownDisplayed() {
        return WaitUtil.waitForVisibility(stateDropdown).isDisplayed();
    }

    /** Checks if Employment Type dropdown is displayed. */
    public boolean isEmploymentTypeDropdownDisplayed() {
        return WaitUtil.waitForVisibility(employmentTypeDropdown)
                .isDisplayed();
    }

    /** Checks if Pay Frequency dropdown is displayed. */
    public boolean isPayFrequencyDropdownDisplayed() {
        return WaitUtil.waitForVisibility(payFrequencyDropdown)
                .isDisplayed();
    }

    // ========== Navigation Links Validation ==========

    /** Checks if Jobs link is displayed. */
    public boolean isJobsLinkDisplayed() {
        return WaitUtil.waitForVisibility(jobsLink).isDisplayed();
    }

    /** Checks if Login link is displayed. */
    public boolean isLoginLinkDisplayed() {
        return WaitUtil.waitForVisibility(loginLink).isDisplayed();
    }
}


