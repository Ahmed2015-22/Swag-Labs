# 🧪 Automation Testing Framework

## 🔍 Project: Swag-Labs-TAF

A **robust, maintainable, and scalable** Test Automation Framework (TAF) built with **Java**, **Selenium WebDriver**, and **TestNG**. This project implements industry best practices to ensure high-quality automation for the Swag Labs e-commerce platform.

---

## 🚀 Features

* ✅ **Java + TestNG** based test execution.
* 🧩 **Page Object Model (POM)** design pattern for maximum reusability.
* 📊 **Data-Driven Testing** using **JSON files** for dynamic test inputs.
* ⏳ **Explicit Waits Utility** for reliable element synchronization.
* 📸 **Media Handling** for capturing screenshots and logs during execution.
* 🪵 **Listeners** implementation for advanced test monitoring and reporting.
* 🧱 **Clean Architecture** separating page actions from test logic.
* ⚙️ **Environment-based execution** support (Local/Headless).

---

## 🏗️ Framework Structure

Based on the project's modular design:

```text
├── src/main/java/com/SwagLabs
│   ├── pages           # Page Classes (P1_LoginPage, P2_ProductsPage, etc.)
│   ├── drivers         # WebDriver configurations
│   ├── listeners       # TestNG Listeners for reporting/logs
│   ├── utils           # Utility classes (FileUtils, etc.)
│   ├── validations     # Custom validation logic
│   └── media           # Screenshot and media utilities
├── src/test/java/com/SwagLabs
│   ├── tests           # Test Cases (TC1_LoginTest to TC6_CompleteTest)
│   └── BaseTest.java   # Setup and Teardown configurations
└── src/test/resources
    └── test-data       # Data-driven JSON files (login-data.json, etc.)
```
🧪 Scenarios Covered
The framework automates the complete End-to-End flow:

Login: Testing with multiple user roles using JSON data.

Products: Inventory navigation and product selection.

Cart: Validating cart items and persistence.

Checkout: Complete multi-step checkout process.

Overview & Finish: Final order verification and completion.
Execute testng.xml or run via Maven:
```
mvn clean test
```
## 👨‍💻 Author
**Ahmed El-Sharkawi**  
*Junior Test Automation Engineer*

🔗 [LinkedIn Profile](https://www.linkedin.com/in/ahmed-el-sharkawi/)
🔗 [GitHub Profile](https://github.com/Ahmed2015-22)


