package com.anamirza.qa.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads configuration data from config.properties file.
 * Uses classpath loading — works locally and in CI/CD.
 */
public class ConfigReader {
    private static final Properties properties = new Properties();

    // Load config file only once when class is first used
    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties not found in src/test/resources/");
            }
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(
                    "Failed to load config.properties", e);
        }
    }
    // Private constructor — no one should instantiate this class
    private ConfigReader() {}

    // Get browser name (chrome / firefox / edge)
    public static String getBrowser() {
        return properties.getProperty("browser");
    }

    // Get application base URL
    public static String getUrl() {
        return properties.getProperty("url");
    }

    // Get explicit wait timeout in seconds
    public static int getTimeout() {
        return Integer.parseInt(
                properties.getProperty("timeout"));
    }
}