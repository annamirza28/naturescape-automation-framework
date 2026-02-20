package com.anamirza.qa.utils;

import com.anamirza.qa.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Utility class for capturing screenshots
 */

public class ScreenshotUtil {
    /**
     * Takes screenshot and saves it in reports/screenshots folder
     */
    public static String takeScreenshot(String testName) {

        WebDriver driver = DriverFactory.getDriver();

        // Take screenshot
        File srcFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        // Create timestamp
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());

        // Path where screenshot will be saved
        String path = "reports/screenshots/"
                + testName + "_"
                + timestamp + ".png";

        File destFile = new File(path);

        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
