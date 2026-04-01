package com.anamirza.qa.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryAnalyzer — automatically retries failed tests up to MAX_RETRY times.
 * Used for flaky tests that are timing-sensitive in full suite runs.
 * Real companies use this pattern for tests that depend on page load times.
 */
public class RetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private static final int MAX_RETRY = 2;

    /**
     * Returns true if the test should be retried.
     * TestNG will re-run the test up to MAX_RETRY times.
     *
     * @param result the result of the failed test
     * @return true to retry, false to mark as failed
     */
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY) {
            retryCount++;
            System.out.println("[RetryAnalyzer] Retrying test: "
                    + result.getName()
                    + " | Attempt: " + retryCount
                    + " of " + MAX_RETRY);
            return true;
        }
        return false;
    }
}