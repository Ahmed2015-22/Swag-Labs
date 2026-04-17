# 🧪 Automation Testing Framework

## 🔍 Project: Swag-Labs-TAF

A **robust, maintainable, and scalable** Test Automation Framework (TAF) built using **Java**, **Selenium WebDriver**, and **TestNG**.
This framework follows industry best practices to deliver reliable, reusable, and clean automated tests for the Swag Labs e-commerce platform.

---

## 🚀 Features

* ✅ **Java + TestNG** for structured and scalable test execution
* 🧩 **Page Object Model (POM)** for high reusability and maintainability
* 📊 **Data-Driven Testing** using JSON files
* ⏳ **Explicit Waits Utility** for stable execution
* 📸 **Screenshot Capture** on failure
* 🪵 **TestNG Listeners** for logging
* 📊 **Allure Reporting Integration**
* 🧱 **Clean Architecture**
* ⚙️ **Environment Support** (Local & Headless)

---

## 🧰 Tech Stack

* **Java 21**
* **Selenium WebDriver 4**
* **TestNG**
* **Maven**
* **Allure Reports**
* **JSON**

---

## 🏗️ Framework Structure

```text
├── src/main/java/com/SwagLabs
│   ├── pages
│   ├── drivers
│   ├── listeners
│   ├── utils
│   ├── validations
│   └── media
│
├── src/test/java/com/SwagLabs
│   ├── tests
│   └── BaseTest.java
│
└── src/test/resources
    └── test-data
```

---

## 🧪 Test Scenarios

* ✅ Login with valid / invalid users
* ✅ Product selection & navigation
* ✅ Add / remove items from cart
* ✅ Checkout process validation
* ✅ Order confirmation

---

## 📊 Allure Report

This framework integrates **Allure Reports** for advanced test reporting.

### 📸 Report Preview

> (Add screenshots here)

```
/screenshots/allure-report.png
```

### ▶️ Generate Allure Report

```bash
mvn clean test
cd allure serve
```

### 📁 Generate Static Report

```bash
allure generate target/allure-results --clean -o allure-report
```

---

## ⚙️ Setup & Execution

### 1️⃣ Clone the repository

```bash
git clone (https://github.com/Ahmed2015-22/Swag-Labs.git)
Swag-Labs
```

### 2️⃣ Install dependencies

```bash
mvn clean install
```

### 3️⃣ Run tests

```bash
mvn clean test
```

---

## ⚡ Execution Options

* 🖥️ Local Execution
* 🕶️ Headless Mode

---

## 👨‍💻 Author
**Ahmed El-Sharkawi**  
*Junior Test Automation Engineer*

🔗 [LinkedIn Profile](https://www.linkedin.com/in/ahmed-el-sharkawi/)
🔗 [GitHub Profile](https://github.com/Ahmed2015-22)


