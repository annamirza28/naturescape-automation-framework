package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape Services Page.
 * URL: https://naturescapelawncare.com/us/services/
 * Verifies all 10 service boxes are displayed:
 * Lawn Care, Tree and Shrub Care, Pruning, Lawn Mowing,
 * Snow Removal, Aeration, Mosquito Control, Grub Control,
 * Lime Application, Fall Cleanup.
 */
public class ServicesPage {

    private final WebDriver driver;

    // ========== Locators ==========
    private final By pageHeading =
            By.xpath("//h1[text()='Our Services']");
    private final By lawnCareBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Lawn Care']");
    private final By treeShrubCareBox =
            By.xpath("//div[@class='servicebox2line' " +
                    "and contains(.,'Tree')]");
    private final By pruningBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Pruning']");
    private final By lawnMowingBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Lawn Mowing']");
    private final By snowRemovalBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Snow Removal']");
    private final By aerationBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Aeration']");
    private final By mosquitoControlBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Mosquito Control']");
    private final By grubControlBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Grub Control']");
    private final By limeApplicationBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Lime Application']");
    private final By fallCleanupBox =
            By.xpath("//div[@class='servicebox1line' " +
                    "and text()='Fall Cleanup']");

    // ========== Constructor ==========

    public ServicesPage(WebDriver driver) {
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
    // ========== Service Box Validation ==========
    /** Checks if Lawn Care service box is displayed. */
    public boolean isLawnCareDisplayed() {
        return WaitUtil.waitForVisibility(lawnCareBox).isDisplayed();
    }

    /** Checks if Tree and Shrub Care service box is displayed. */
    public boolean isTreeShrubCareDisplayed() {
        return WaitUtil.waitForVisibility(treeShrubCareBox).isDisplayed();
    }

    /** Checks if Pruning service box is displayed. */
    public boolean isPruningDisplayed() {
        return WaitUtil.waitForVisibility(pruningBox).isDisplayed();
    }

    /** Checks if Lawn Mowing service box is displayed. */
    public boolean isLawnMowingDisplayed() {
        return WaitUtil.waitForVisibility(lawnMowingBox).isDisplayed();
    }

    /** Checks if Snow Removal service box is displayed. */
    public boolean isSnowRemovalDisplayed() {
        return WaitUtil.waitForVisibility(snowRemovalBox).isDisplayed();
    }

    /** Checks if Aeration service box is displayed. */
    public boolean isAerationDisplayed() {
        return WaitUtil.waitForVisibility(aerationBox).isDisplayed();
    }

    /** Checks if Mosquito Control service box is displayed. */
    public boolean isMosquitoControlDisplayed() {
        return WaitUtil.waitForVisibility(mosquitoControlBox).isDisplayed();
    }

    /** Checks if Grub Control service box is displayed. */
    public boolean isGrubControlDisplayed() {
        return WaitUtil.waitForVisibility(grubControlBox).isDisplayed();
    }

    /** Checks if Lime Application service box is displayed. */
    public boolean isLimeApplicationDisplayed() {
        return WaitUtil.waitForVisibility(limeApplicationBox).isDisplayed();
    }

    /** Checks if Fall Cleanup service box is displayed. */
    public boolean isFallCleanupDisplayed() {
        return WaitUtil.waitForVisibility(fallCleanupBox).isDisplayed();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
}
