# SauceDemo-Selenium-TestNG-Framework

## Overview
This is a Selenium automation framework using TestNG for end-to-end testing of the SauceDemo website. The framework follows the Page Object Model (POM) for better maintainability and scalability.

## Features
- **Page Object Model (POM) implementation**
- **TestNG integration** for test execution
- **Data-driven testing** using Excel (Apache POI)
- **Extent Reports** for test reporting
- **Logging using log4j**
- **Screenshots on test failures**

## Tech Stack
- **Java** (JDK 1.7 or higher)
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Apache POI** (for Excel data handling)
- **Extent Reports** (for reporting)
- **Log4j** (for logging)

## Project Structure
```
SauceDemo-POM-TestNG
│── src
│   ├── main
│   │   ├── java
│   │   │   ├── base
│   │   │   │   ├── Base.java
│   │   │   ├── pages
│   │   │   │   ├── CartPage.java
│   │   │   │   ├── CheckoutPage.java
│   │   │   │   ├── InventoryPage.java
│   │   │   │   ├── LoginPage.java
│   │   │   ├── resources
│   │   │   │   ├── Data.java
│   │   │   │   ├── ExtentReporter1.java
│   │   │   │   ├── ReadExcel.java
│   │   │   │   ├── Utilities.java
│   │   │   │   ├── log4j.xml
│   │   │   │   ├── TestData.xlsx
│   │   │   ├── data.properties
│   ├── test
│   │   ├── java
│   │   │   ├── testcases
│   │   │   │   ├── E2ETest.java
│   │   │   │   ├── Listener1.java
│── Maven Dependencies
│── logs/
│── screenshots/
│── test-output/
│── pom.xml
│── README.md
│── testng.xml
```

## Setup Instructions
1. **Clone the repository**:
   ```sh
   git clone https://github.com/ishivamkunal/SauceDemo-Selenium-TestNG-Framework.git
   ```

2. **Open the project in Eclipse or IntelliJ**

3. **Install dependencies using Maven**:
   ```sh
   mvn clean install
   ```

4. **Update `data.properties` file** with correct values

5. **Run tests** using TestNG:
   ```sh
   mvn test
   ```
   Or directly run `testng.xml` from the IDE.

## Running Tests
- To run a single test:
  ```sh
  mvn -Dtest=E2ETest test
  ```
- To generate reports:
  ```sh
  mvn surefire-report:report
  ```

## Reporting & Logs
- **Extent Reports** are generated in `ExtentReports/`
- **Screenshots** for failed tests are stored in `screenshots/`
- **Logs** are stored in `logs/`
