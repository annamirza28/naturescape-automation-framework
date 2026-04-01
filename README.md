# 🌿 Naturescape Automation Framework

> A production-grade Selenium UI automation framework for [naturescapelawncare.com](https://naturescapelawncare.com), built with Java 22, TestNG, and the Page Object Model pattern.

![Java](https://img.shields.io/badge/Java-22-orange?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.17.0-43B02A?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-red)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven)
![Tests](https://img.shields.io/badge/Tests-184%20Passing-brightgreen)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Test Coverage](#test-coverage)
- [Framework Architecture](#framework-architecture)
- [Setup & Installation](#setup--installation)
- [Running Tests](#running-tests)
- [Test Reports](#test-reports)
- [CI/CD Pipeline](#cicd-pipeline)
- [Design Patterns](#design-patterns)

---

## Overview

This framework provides end-to-end UI test coverage for the Naturescape Lawn Care website. It validates critical user journeys including navigation, form submissions, page content integrity, account management, and payment flows.

**Key stats:**
- ✅ 184 tests — 100% pass rate
- ⏱️ Full suite runtime: ~10 minutes 26 seconds
- 📄 15 page objects covering the entire site
- 🔁 Auto-retry logic for flaky test resilience
- 📊 Extent HTML reports generated on every run

---

## Tech Stack

| Tool | Version | Purpose |
|---|---|---|
| Java | 22 | Core language |
| Selenium WebDriver | 4.17.0 | Browser automation |
| TestNG | 7.9.0 | Test execution & assertions |
| WebDriverManager | 5.9.2 | Automatic driver binary management |
| ExtentReports | 5.1.1 | HTML test reporting |
| Maven | 3.x | Build & dependency management |
| IntelliJ IDEA | Latest | IDE |

---

## Project Structure

```
naturescape-automation-framework/
│
├── src/
│   ├── main/java/com/anamirza/qa/
│   │   ├── base/
│   │   │   └── BaseTest.java              # WebDriver setup/teardown
│   │   ├── pages/
│   │   │   ├── HomePage.java
│   │   │   ├── AboutPage.java
│   │   │   ├── ContactUsPage.java
│   │   │   ├── CustomerServiceResponsePage.java
│   │   │   ├── JobListingsAtNaturescapePage.java
│   │   │   ├── NaturescapeLocationsPage.java
│   │   │   ├── ServicesPage.java
│   │   │   ├── GetStartedPage.java
│   │   │   ├── LawnTipsPage.java
│   │   │   ├── MakeSelfStoragePaymentPage.java
│   │   │   ├── MyAccountPage.java
│   │   │   ├── PaymentPage.java
│   │   │   ├── TermsAndConditionsPage.java
│   │   │   ├── TermsAndPrivacyPage.java
│   │   │   └── ... (15 total)
│   │   └── utils/
│   │       └── (utility helpers)
│   │
│   └── test/java/com/anamirza/qa/
│       ├── listeners/
│       │   ├── ExtentReportListener.java  # HTML report generation
│       │   └── RetryAnalyzer.java         # Flaky test retry (max 3x)
│       └── tests/
│           ├── HomePageTests.java
│           ├── AboutPageTests.java
│           ├── ContactUsPageTests.java
│           └── ... (15 test classes)
│
├── src/test/resources/
│   └── testng.xml                         # Suite configuration
│
├── test-output/                           # ExtentReports HTML output
├── pom.xml
└── README.md
```

---

## Test Coverage

| Test Class | Tests | Area Covered |
|---|---|---|
| `HomePageTests` | 21 | Headings, navigation, URL, page title, sign-up |
| `AboutPageTests` | 6 | Company info, page content assertions |
| `ContactUsPageTests` | 14 | Form fields, submission, validation |
| `CustomerServiceResponsePageTests` | 10 | Form response, confirmation content |
| `JobListingsAtNaturescapePageTests` | 12 | Job listings, apply flow |
| `NaturescapeLocationsPageTests` | 11 | Location listings, map elements |
| `ServicesPageTests` | 13 | Service cards, CTAs, content |
| `GetStartedPageTests` | 21 | Onboarding flow, form validation |
| `LawnTipsPageTests` | 12 | Blog/tips content, navigation |
| `MakeSelfStoragePaymentPageTests` | 16 | Payment form, field validation |
| `MyAccountPageTests` | 18 | Login, account sections |
| `PaymentPageTests` | 21 | Payment processing UI, fields |
| `TermsAndConditionsPageTests` | 3 | Legal content assertions |
| `TermsAndPrivacyPageTests` | 6 | Privacy policy content |
| **Total** | **184** | **100% Pass Rate** |

---

## Framework Architecture

### Page Object Model (POM)

Each page is encapsulated in its own class using `@FindBy` annotations and `PageFactory`:

```java
public class HomePage extends BaseTest {

    @FindBy(css = "h1.page-heading")
    private WebElement pageHeading;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getPageHeading() {
        return pageHeading.getText();
    }
}
```

### BaseTest

Handles WebDriver lifecycle — initialization via WebDriverManager and teardown after each test:

```java
@BeforeMethod
public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(BASE_URL);
}

@AfterMethod
public void tearDown() {
    if (driver != null) driver.quit();
}
```

### RetryAnalyzer

Automatically retries failed tests up to 3 times before marking as failed:

```java
public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;
    private static final int MAX_RETRY = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRY) { count++; return true; }
        return false;
    }
}
```

### ExtentReportListener

Generates a rich HTML report with pass/fail status, test names, and timestamps after every suite run.

---

## Setup & Installation

### Prerequisites

- Java 22+ installed and `JAVA_HOME` configured
- Maven 3.x installed
- Google Chrome (latest)
- IntelliJ IDEA (recommended) or any Java IDE

### Clone & Install

```bash
git clone https://github.com/annamirza28/naturescape-automation-framework.git
cd naturescape-automation-framework
mvn clean install -DskipTests
```

---

## Running Tests

### Run the full suite via Maven:

```bash
mvn test
```

### Run via TestNG XML directly (IntelliJ):

Right-click `testng.xml` → **Run**

### Run a specific test class:

```bash
mvn test -Dtest=HomePageTests
```

### Run with a specific browser (if configured):

```bash
mvn test -Dbrowser=firefox
```

---

## Test Reports

After each run, an HTML report is generated at:

```
test-output/ExtentReport.html
```

Open it in any browser. The report includes:

- ✅ Pass / ❌ Fail / ⚠️ Skip counts
- Test duration per method
- Suite-level summary
- Failure stack traces inline

---

## CI/CD Pipeline

### Jenkins (Local or Remote)

1. Install Jenkins and the **Maven Integration** plugin
2. Create a **New Freestyle Project**
3. Under **Source Code Management** → Git → add your repo URL
4. Under **Build** → add Maven goal: `clean test`
5. Under **Post-build Actions** → Publish HTML reports → point to `test-output/`

### GitHub Actions

A workflow file is provided at `.github/workflows/ci.yml`:

```yaml
name: Naturescape UI Tests

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up Java 22
        uses: actions/setup-java@v3
        with:
          java-version: '22'
          distribution: 'temurin'

      - name: Run TestNG suite
        run: mvn clean test

      - name: Upload Extent Report
        uses: actions/upload-artifact@v3
        if: always()
        with:
          name: extent-report
          path: test-output/ExtentReport.html
```

---

## Design Patterns

| Pattern | Implementation |
|---|---|
| **Page Object Model** | All UI interactions encapsulated in page classes |
| **Factory Pattern** | `PageFactory.initElements()` for element initialization |
| **Singleton** | Single WebDriver instance per test method |
| **Listener Pattern** | TestNG `ITestListener` for report hooks |
| **Retry Pattern** | `IRetryAnalyzer` for transient failure resilience |

---

## Author

**Ana Mirza**
- GitHub: [@annamirza28](https://github.com/annamirza28)
- Framework: [naturescape-automation-framework](https://github.com/annamirza28/naturescape-automation-framework)

---

*Built as a portfolio project demonstrating enterprise-level Selenium automation practices.*
