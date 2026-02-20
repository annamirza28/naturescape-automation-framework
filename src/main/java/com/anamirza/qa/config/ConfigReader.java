package com.anamirza.qa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Reads data from config.properties file
 * (browser, url, timeout, etc.)
 */

public class ConfigReader {
    private static Properties properties;

    // Load config file only once
    static {
        try {
            FileInputStream file = new FileInputStream(
                    "src/test/resources/config.properties"
            );

            properties = new Properties();
            properties.load(file);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties");
        }
    }
    // Get browser name
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    // Get application URL
    public static String getUrl() {
        return properties.getProperty("url");
    }

    // Get timeout
    public static int getTimeout() {
        return Integer.parseInt(
                properties.getProperty("timeout")
        );
    }
}
