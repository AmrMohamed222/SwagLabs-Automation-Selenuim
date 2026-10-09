# Swag Labs Automation Testing Project

## 📌 Project Overview

This project focuses on automating web application testing for **Swag Labs**, an e-commerce demo application, using Selenium WebDriver with Java.

The goal is to practice automation testing concepts, validate essential e-commerce functionalities, and build maintainable automated test scripts using the Page Object Model (POM).

## 🎯 Project Objectives

* Automate user interactions with the web application.
* Validate login functionality.
* Automate product selection and add-to-cart operations.
* Verify cart contents and item quantities.
* Practice reusable and maintainable test automation code.
* Improve skills in web element identification, synchronization, and assertions.

## 🧪 Test Scenarios

The project covers the following testing scenarios:

### 1. Login Testing

* Verify successful login with valid credentials.
* Validate navigation to the products page after login.

### 2. Product Selection

* Locate products on the products page.
* Select products by their names.
* Automate adding products to the shopping cart.

### 3. Shopping Cart Validation

* Verify that selected products are added to the cart.
* Validate the shopping cart item count.
* Check that the cart reflects the selected products.

### 4. Assertions and Synchronization

* Validate expected page titles and application states.
* Use Selenium waits to handle dynamic web elements.
* Verify expected results using assertions.

*Note: The scenarios listed above describe the project's intended test coverage. Refer to the implemented test classes for the exact scenarios currently automated.*

## 🛠️ Technologies & Tools

* **Java** — Programming language
* **Selenium WebDriver** — Browser automation
* **TestNG** — Test execution and assertions
* **Maven** — Project and dependency management, if configured
* **Page Object Model (POM)** — Test automation design pattern
* **ChromeDriver** — Chrome browser automation

## 🏗️ Project Structure

The project uses a structured approach to organize test code and page-related functionality.

```text
SwagLabs-Automation-Selenuim/
├── src/
│   └── test/
│       └── java/
│           ├── login/
│           └── ...
├── pom.xml
└── README.md
```

*The structure above is illustrative. Update it to match the actual folders and files in the repository.*

## ⚙️ Prerequisites

Before running the tests, make sure you have:

* Java Development Kit (JDK) installed.
* IntelliJ IDEA or another Java IDE.
* Google Chrome installed.
* Maven installed, if the project uses Maven.
* The required project dependencies configured.

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/AmrMohamed222/SwagLabs-Automation-Selenuim.git
```

### 2. Open the Project

Open the cloned project in IntelliJ IDEA and allow the IDE to load its dependencies.

### 3. Configure the Environment

Make sure the browser driver configuration and required dependencies are set up correctly.

If the project uses Maven, verify that the `pom.xml` file contains the required Selenium and TestNG dependencies.

### 4. Run the Tests

Run the required test class from your IDE.

If the project is configured with Maven and a suitable test runner, you can also execute:

```bash
mvn test
```

## 📚 Key Learning Outcomes

Through this project, I am developing practical skills in:

* Selenium WebDriver automation using Java.
* Locating web elements with XPath and other Selenium locators.
* Applying the Page Object Model to organize automation code.
* Handling browser interactions and dynamic elements.
* Using assertions to validate expected behavior.
* Automating core e-commerce workflows.
* Writing reusable and maintainable test scripts.

## 👨‍💻 Author

**Amr Mohamed**

Aspiring Automation Tester | Software Testing | Java | Selenium WebDriver

🔗 **GitHub:** [AmrMohamed222](https://github.com/AmrMohamed222)

---

⭐ If you find this project useful, feel free to explore the repository.
