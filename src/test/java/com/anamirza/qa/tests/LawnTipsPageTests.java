package com.anamirza.qa.tests;

import com.anamirza.qa.base.BaseTest;
import com.anamirza.qa.pages.LawnTipsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
     * Test suite for the Naturescape Lawn Tips Page.
     * URL: <a href="https://naturescapelawncare.com/us/lawntips/">Lawn Tips Page</a>
     * Verifies:
     * - Correct URL after navigation
     * - Page heading is displayed with correct text
     * - All 9 lawn tip boxes are displayed
     */
    public class LawnTipsPageTests extends BaseTest {
        private LawnTipsPage lawnTipsPage;
        // ========== Setup ==========
        @BeforeMethod
        public void setUpPage() {
            driver.get("https://naturescapelawncare.com/us/lawntips/");
            lawnTipsPage = new LawnTipsPage(driver);
        }
        // ========== URL & Page Load Tests ==========
        @Test(description = "Verify Lawn Tips page URL is correct after navigation")
        public void shouldNavigateToLawnTipsPageWithCorrectURL() {
            // Arrange
            String expectedURL = "https://naturescapelawncare.com/us/lawntips/";
            // Act
            String actualURL = lawnTipsPage.getPageURL();
            // Assert
            Assert.assertEquals(actualURL, expectedURL,
                    "Lawn Tips page URL is incorrect. " +
                            "Expected: " + expectedURL +
                            " but got: " + actualURL);
        }
        @Test(description = "Verify Lawn Tips page heading is displayed")
        public void shouldDisplayHeadingOnLawnTipsPage() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isHeadingDisplayed(),
                    "Heading should be displayed on Lawn Tips page");
        }
        @Test(description = "Verify Lawn Tips page heading text is correct")
        public void shouldDisplayCorrectHeadingTextOnLawnTipsPage() {
            // Arrange
            String expected = "Lawn Care Tips";
            // Act
            String actual = lawnTipsPage.getHeadingText();
            // Assert
            Assert.assertEquals(actual, expected,
                    "Lawn Tips heading text is incorrect. " +
                            "Expected: " + expected + " but got: " + actual);
        }
        // ========== Tip Box Tests ==========
        @Test(description = "Verify Aeration tip box is displayed")
        public void shouldDisplayAerationTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isAerationDisplayed(),
                    "Aeration tip box should be displayed");
        }
        @Test(description = "Verify Mowing tip box is displayed")
        public void shouldDisplayMowingTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isMowingDisplayed(),
                    "Mowing tip box should be displayed");
        }
        @Test(description = "Verify Watering tip box is displayed")
        public void shouldDisplayWateringTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isWateringDisplayed(),
                    "Watering tip box should be displayed");
        }
        @Test(description = "Verify Thatch tip box is displayed")
        public void shouldDisplayThatchTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isThatchDisplayed(),
                    "Thatch tip box should be displayed");
        }
        @Test(description = "Verify Diseases tip box is displayed")
        public void shouldDisplayDiseasesTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isDiseasesDisplayed(),
                    "Diseases tip box should be displayed");
        }
        @Test(description = "Verify Insects tip box is displayed")
        public void shouldDisplayInsectsTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isInsectsDisplayed(),
                    "Insects tip box should be displayed");
        }
        @Test(description = "Verify Shady Lawns tip box is displayed")
        public void shouldDisplayShadyLawnsTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isShadyLawnsDisplayed(),
                    "Shady Lawns tip box should be displayed");
        }
        @Test(description = "Verify Weedy Perennials tip box is displayed")
        public void shouldDisplayWeedyPerennialsTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isWeedyPerennialsDisplayed(),
                    "Weedy Perennials tip box should be displayed");
        }
        @Test(description = "Verify Other Problems tip box is displayed")
        public void shouldDisplayOtherProblemsTipBox() {
            // Assert
            Assert.assertTrue(lawnTipsPage.isOtherProblemsDisplayed(),
                    "Other Problems tip box should be displayed");
        }
    }

