package com.anamirza.qa.pages;

import com.anamirza.qa.utils.JavaScriptUtil;
import com.anamirza.qa.utils.WaitUtil;
import com.anamirza.qa.utils.WindowManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Page Object for the Naturescape My Account Page.
 * URL: <a href="https://naturescapelawncare.com/us/account/">My Account Page</a>
 * Handles:
 * - Page validation (heading, buttons, form fields)
 * - Navigation to Payment, Storage Payment, Get Started pages
 */
public class MyAccountPage {
    private final WebDriver driver;
    private final WindowManager windowManager;
    private final By pageHeading = By.xpath("//h1[text()='My Account']");
    private final By makePaymentButton = By.xpath("//button[text()='Make a Payment']");
    private final By addNewServiceButton = By.xpath("//button[text()='Add New Service']");
    private final By makeSelfStoragePaymentButton = By.xpath("//button[text()='Make Self Storage Payment']");
    private final By phoneField = By.cssSelector("input.phoneInput");
    private final By emailField = By.cssSelector("input.emailInput");
    private final By textButton = By.xpath("//button[text()='Text']");
    private final By callButton = By.xpath("//button[text()='Call']");
    private final By emailButton = By.xpath("//button[text()='Email']");
    private final By loginButton = By.cssSelector("button.loginButton");
    private final By codeInput = By.xpath("//input[@class='codeInput']");

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        this.windowManager = new WindowManager(driver);
    }
    /** Returns the current page URL. */
    public String getPageURL() {
        return driver.getCurrentUrl();
    }
    /** Returns the page title using JavaScript. */
    public String getPageTitle() {
        return JavaScriptUtil.getTitleByJS();
    }
    /** Checks if the My Account heading is displayed. */
    public boolean isPageHeadingDisplayed() {
        return WaitUtil.waitForVisibility(pageHeading).isDisplayed();
    }
    /** Returns the page heading text. */
    public String getPageHeadingText() {
        return WaitUtil.waitForVisibility(pageHeading).getText().trim();
    }
    // ========== Button Validation ==========
    /** Checks if Make a Payment button is displayed. */
    public boolean isMakePaymentButtonDisplayed() {
        return WaitUtil.waitForVisibility(makePaymentButton)
                .isDisplayed();
    }
    /** Checks if Add New Service button is displayed. */
    public boolean isAddNewServiceButtonDisplayed() {
        return WaitUtil.waitForVisibility(addNewServiceButton)
                .isDisplayed();
    }
    /** Checks if Make Self Storage Payment button is displayed. */
    public boolean isMakeSelfStoragePaymentButtonDisplayed() {
        return WaitUtil.waitForVisibility(makeSelfStoragePaymentButton)
                .isDisplayed();
    }
    // ========== Form Field Validation ==========

    /** Checks if Phone field is displayed. */
    public boolean isPhoneFieldDisplayed() {
        return WaitUtil.waitForVisibility(phoneField).isDisplayed();
    }

    /** Checks if Email field is displayed. */
    public boolean isEmailFieldDisplayed() {
        return WaitUtil.waitForVisibility(emailField).isDisplayed();
    }

    /** Checks if Text button is displayed. */
    public boolean isTextButtonDisplayed() {
        return WaitUtil.waitForVisibility(textButton).isDisplayed();
    }

    /** Checks if Call button is displayed. */
    public boolean isCallButtonDisplayed() {
        return WaitUtil.waitForVisibility(callButton).isDisplayed();
    }

    /** Checks if Email button is displayed. */
    public boolean isEmailButtonDisplayed() {
        return WaitUtil.waitForVisibility(emailButton).isDisplayed();
    }

    /** Checks if Login button is displayed. */
    public boolean isLoginButtonDisplayed() {
        return WaitUtil.waitForVisibility(loginButton).isDisplayed();
    }

    /** Checks if Code input is displayed. */
    public boolean isCodeInputDisplayed() {
        return WaitUtil.waitForVisibility(codeInput).isDisplayed();
    }

    // ========== Navigation ==========

    /**
     * Clicks Make a Payment button.
     * Navigates to Payment page in same tab.
     */
    public PaymentPage clickMakePayment() {
        WaitUtil.waitForClickable(makePaymentButton).click();
        return new PaymentPage(driver);
    }

    /**
     * Clicks Make Self Storage Payment button.
     * Navigates to Storage Payment page in same tab.
     */
    public MakeSelfStoragePaymentPage clickMakeSelfStoragePayment() {
        WaitUtil.waitForClickable(makeSelfStoragePaymentButton).click();
        return new MakeSelfStoragePaymentPage(driver);
    }

    /**
     * Clicks Add New Service button.
     * Navigates to Get Started page in same tab.
     */
    public GetStartedPage clickAddNewService() {
        WaitUtil.waitForClickable(addNewServiceButton).click();
        return new GetStartedPage(driver);
    }
}

