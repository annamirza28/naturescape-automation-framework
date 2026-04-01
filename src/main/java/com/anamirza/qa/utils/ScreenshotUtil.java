package com.anamirza.qa.utils;

import com.anamirza.qa.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for capturing screenshots on test failure.
 * Saves to: reports/screenshots/<testName>_<timestamp>.png
 */
public class ScreenshotUtil {

    // Thread-safe — DateTimeFormatter is immutable
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    // Private constructor — utility class, not instantiatable
    private ScreenshotUtil() {}

    /**
     * Takes a screenshot and saves it to reports/screenshots/.
     * @param testName  name of the failed test (used in filename)
     * @return absolute path to the saved screenshot
     */
    public static String takeScreenshot(String testName) {

        WebDriver driver = DriverFactory.getDriver();

        // Guard — driver might be null if browser never opened
        if (driver == null) {
            System.err.println(
                    "[ScreenshotUtil] Driver is null — skipping screenshot.");
            return null;
        }

        // Capture screenshot bytes
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // Build timestamped filename
        String timestamp = LocalDateTime.now().format(FORMATTER);
        String path = "reports/screenshots/"
                + testName + "_" + timestamp + ".png";

        File destFile = new File(path);

        // Create directory if it doesn't exist yet
        destFile.getParentFile().mkdirs();

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to save screenshot: " + path, e);
        }

        return destFile.getAbsolutePath();
    }
}