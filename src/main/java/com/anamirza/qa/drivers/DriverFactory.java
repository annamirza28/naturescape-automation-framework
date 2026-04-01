package com.anamirza.qa.drivers;

import com.anamirza.qa.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

/**
 * Manages WebDriver creation and lifecycle.
 * Uses ThreadLocal for thread-safe parallel execution.
 * Single Responsibility: creates browser only — does NOT navigate.
 */
public class DriverFactory {

    // final = this reference is never reassigned
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor — no one should instantiate this class
    private DriverFactory() {}

    public static void initDriver() {

        String browser = ConfigReader.getBrowser()
                .toLowerCase()
                .trim();

        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = getChromeOptions();
                driver.set(new ChromeDriver(options));
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--start-maximized");
                driver.set(new FirefoxDriver(options));
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                driver.set(new EdgeDriver(options));
            }
            default -> throw new RuntimeException(
                    "Browser not supported: '" + browser +
                            "'. Use: chrome, firefox, or edge");
        }

        // Set page load timeout — don't wait forever if site is slow
        getDriver().manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(
                        ConfigReader.getTimeout()));
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-first-run");
        options.addArguments("--no-default-browser-check");
        options.addArguments("--disable-extensions");
        options.addArguments("--incognito");
        // Run headless in CI environments (GitHub Actions = no display)
        if (Boolean.parseBoolean(System.getenv().getOrDefault("CI", "false"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        }

        return options;
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}