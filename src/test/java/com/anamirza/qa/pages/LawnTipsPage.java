package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object for the Naturescape Lawn Tips Page.
 * URL: <a href="https://naturescapelawncare.com/us/lawntips/">Lawn Tips Page</a>
 */
public class LawnTipsPage {
    private final WebDriver driver;
    // ========== Locators ==========
    private final By pageHeading = By.xpath("//h1[text()='Lawn Care Tips']");
    private final By aerationTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Aeration']");
    private final By mowingTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Mowing']");
    private final By wateringTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Watering']");
    private final By thatchTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Thatch']");
    private final By diseasesTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Diseases']");
    private final By insectsTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Insects']");
    private final By shadyLawnsTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Shady Lawns']");
    private final By weedyPerennialsTip = By.xpath("//div[@class='servicebox2line' " +
                    "and contains(.,'Weedy')]");
    private final By otherProblemsTip = By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Other Problems']");
    // ========== Constructor ==========
    public LawnTipsPage(WebDriver driver) {
        this.driver = driver;
    }
    // ========== Page Validation ==========

    /** Returns the current page URL. */
    public String getPageURL() {
        return driver.getCurrentUrl();
    }

    /** Checks if the page heading is displayed. */
    public boolean isHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }

    /** Returns the page heading text. */
    public String getHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }

    // ========== Tip Box Validation ==========

    /** Checks if Aeration tip is displayed. */
    public boolean isAerationDisplayed() {
        return WaitUtil.waitForVisibility(aerationTip).isDisplayed();
    }

    /** Checks if Mowing tip is displayed. */
    public boolean isMowingDisplayed() {
        return WaitUtil.waitForVisibility(mowingTip).isDisplayed();
    }

    /** Checks if Watering tip is displayed. */
    public boolean isWateringDisplayed() {
        return WaitUtil.waitForVisibility(wateringTip).isDisplayed();
    }

    /** Checks if Thatch tip is displayed. */
    public boolean isThatchDisplayed() {
        return WaitUtil.waitForVisibility(thatchTip).isDisplayed();
    }

    /** Checks if Diseases tip is displayed. */
    public boolean isDiseasesDisplayed() {
        return WaitUtil.waitForVisibility(diseasesTip).isDisplayed();
    }

    /** Checks if Insects tip is displayed. */
    public boolean isInsectsDisplayed() {
        return WaitUtil.waitForVisibility(insectsTip).isDisplayed();
    }

    /** Checks if Shady Lawns tip is displayed. */
    public boolean isShadyLawnsDisplayed() {
        return WaitUtil.waitForVisibility(shadyLawnsTip).isDisplayed();
    }

    /** Checks if Weedy Perennials tip is displayed. */
    public boolean isWeedyPerennialsDisplayed() {
        return WaitUtil.waitForVisibility(weedyPerennialsTip).isDisplayed();
    }

    /** Checks if Other Problems tip is displayed. */
    public boolean isOtherProblemsDisplayed() {
        return WaitUtil.waitForVisibility(otherProblemsTip).isDisplayed();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
}
