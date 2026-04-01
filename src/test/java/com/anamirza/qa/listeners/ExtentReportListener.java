package com.anamirza.qa.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.anamirza.qa.utils.ScreenshotUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * ExtentReportListener — TestNG listener that generates
 * an HTML test report after every test run.
 * Automatically:
 * - Creates a test entry when each test starts
 * - Marks tests GREEN (pass), RED (fail), YELLOW (skip)
 * - Attaches screenshot to report on failure
 * - Saves the HTML report when the suite finishes
 * Registered in testng.xml — no manual calls needed.
 */
public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;// One ExtentReports instance for the whole suite

    private static final ThreadLocal<ExtentTest> testThread =
            new ThreadLocal<>(); // One ExtentTest per thread — safe for parallel execution

    // -------------------------------------------------------
    // Suite level — runs once at start and end of entire suite
    // -------------------------------------------------------

    @Override
    public void onStart(ITestContext context) {
        // Define where the HTML report will be saved
        String reportPath = "reports/ExtentReport.html";

        // SparkReporter builds the actual HTML file
        ExtentSparkReporter sparkReporter =
                new ExtentSparkReporter(reportPath);

        // Report appearance settings
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle(
                "Naturescape Automation Report");
        sparkReporter.config().setReportName(
                "UI Automation Test Results");
        sparkReporter.config().setEncoding("UTF-8");

        // Create the main ExtentReports instance
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system info shown at top of report
        extent.setSystemInfo("Project",
                "Naturescape Lawn Care Automation");
        extent.setSystemInfo("Tester",
                System.getProperty("user.name"));
        extent.setSystemInfo("OS",
                System.getProperty("os.name"));
        extent.setSystemInfo("Java Version",
                System.getProperty("java.version"));
        extent.setSystemInfo("Environment",
                "https://naturescapelawncare.com");
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush writes everything to the HTML file
        // Without this — the report file will be empty
        if (extent != null) {
            extent.flush();
        }
    }

    // -------------------------------------------------------
    // Test level — runs for every single test method
    // -------------------------------------------------------

    @Override
    public void onTestStart(ITestResult result) {
        // Create a new test entry in the report
        String testName = result.getMethod().getMethodName();
        String className = result.getTestClass().getName();

        ExtentTest test = extent.createTest(
                testName,
                "Class: " + className);

        // Store in ThreadLocal — safe for parallel runs
        testThread.set(test);
        testThread.get().log(Status.INFO,
                "Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().log(Status.PASS,
                "Test PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();

        // Log the failure reason
        testThread.get().log(Status.FAIL,
                "Test FAILED: " + testName);

        // Log the exception message
        testThread.get().log(Status.FAIL,
                result.getThrowable().getMessage());

        // Take screenshot and attach it to the report
        String screenshotPath =
                ScreenshotUtil.takeScreenshot(testName);

        if (screenshotPath != null) {
            try {
                testThread.get().addScreenCaptureFromPath(
                        screenshotPath,
                        "Failure Screenshot");
            } catch (Exception e) {
                testThread.get().log(Status.WARNING,
                        "Could not attach screenshot: "
                                + e.getMessage());
            }
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().log(Status.SKIP,
                "Test SKIPPED: " + result.getName());
    }

    // -------------------------------------------------------
    // Helper — lets other classes log to the current test
    // -------------------------------------------------------

    /**
     * Returns the ExtentTest for the current thread.
     * Can be used from test classes to add extra log info.
     * Example usage in a test:
     * ExtentReportListener.getTest().info("Clicked submit button");
     */
    public static ExtentTest getTest() {
        return testThread.get();
    }
}