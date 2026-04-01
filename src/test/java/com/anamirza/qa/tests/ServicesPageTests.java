package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.ServicesPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test suite for the Naturescape Services Page.
 * URL: <a href="https://naturescapelawncare.com/us/services/">Services Page</a>
 * Verifies:
 * - Correct URL after navigation
 * - Page heading is displayed with correct text
 * - All 10 service boxes are displayed
 */
public class ServicesPageTests extends BaseTest {
    private ServicesPage servicesPage;
    // ========== Setup ==========
    @BeforeMethod
    public void setUpPage() {
        driver.get("https://naturescapelawncare.com/us/services/");
        servicesPage = new ServicesPage(driver);
    }
    // ========== URL & Page Load Tests ==========
    @Test(description = "Verify Services page URL is correct after navigation")
    public void shouldNavigateToServicesPageWithCorrectURL() {
        // Arrange
        String expectedURL = "https://naturescapelawncare.com/us/services/";
        // Act
        String actualURL = servicesPage.getPageURL();
        // Assert
        Assert.assertEquals(actualURL, expectedURL,
                "Services page URL is incorrect. " +
                        "Expected: " + expectedURL +
                        " but got: " + actualURL);
    }
    @Test(description = "Verify Services page heading is displayed")
    public void shouldDisplayHeadingOnServicesPage() {
        // Assert
        Assert.assertTrue(servicesPage.isHeadingDisplayed(),
                "Heading should be displayed on Services page");
    }
    @Test(description = "Verify Services page heading text is correct")
    public void shouldDisplayCorrectHeadingTextOnServicesPage() {
        // Arrange
        String expected = "Our Services";
        // Act
        String actual = servicesPage.getHeadingText();
        // Assert
        Assert.assertEquals(actual, expected,
                "Services page heading text is incorrect. " +
                        "Expected: " + expected + " but got: " + actual);
    }
    // ========== Service Box Tests ==========
    @Test(description = "Verify Lawn Care service box is displayed")
    public void shouldDisplayLawnCareServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isLawnCareDisplayed(),
                "Lawn Care service box should be displayed");
    }

    @Test(description = "Verify Tree and Shrub Care service box is displayed")
    public void shouldDisplayTreeShrubCareServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isTreeShrubCareDisplayed(),
                "Tree and Shrub Care service box should be displayed");
    }

    @Test(description = "Verify Pruning service box is displayed")
    public void shouldDisplayPruningServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isPruningDisplayed(),
                "Pruning service box should be displayed");
    }

    @Test(description = "Verify Lawn Mowing service box is displayed")
    public void shouldDisplayLawnMowingServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isLawnMowingDisplayed(),
                "Lawn Mowing service box should be displayed");
    }

    @Test(description = "Verify Snow Removal service box is displayed")
    public void shouldDisplaySnowRemovalServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isSnowRemovalDisplayed(),
                "Snow Removal service box should be displayed");
    }

    @Test(description = "Verify Aeration service box is displayed")
    public void shouldDisplayAerationServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isAerationDisplayed(),
                "Aeration service box should be displayed");
    }

    @Test(description = "Verify Mosquito Control service box is displayed")
    public void shouldDisplayMosquitoControlServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isMosquitoControlDisplayed(),
                "Mosquito Control service box should be displayed");
    }

    @Test(description = "Verify Grub Control service box is displayed")
    public void shouldDisplayGrubControlServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isGrubControlDisplayed(),
                "Grub Control service box should be displayed");
    }

    @Test(description = "Verify Lime Application service box is displayed")
    public void shouldDisplayLimeApplicationServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isLimeApplicationDisplayed(),
                "Lime Application service box should be displayed");
    }

    @Test(description = "Verify Fall Cleanup service box is displayed")
    public void shouldDisplayFallCleanupServiceBox() {
        // Assert
        Assert.assertTrue(servicesPage.isFallCleanupDisplayed(),
                "Fall Cleanup service box should be displayed");
    }
}
