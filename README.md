# Guru99AssignmentProject

## 📌 Project Overview
Guru99AssignmentProject is a **Test Automation Framework** designed to test the **Guru99 Bank Web Application** using **Java, Selenium, TestNG, and Page Object Model (POM)**. It automates login validation and other key functionalities.

## 🚀 Technologies Used
- **Programming Language**: Java
- **Test Automation Tool**: Selenium WebDriver
- **Testing Framework**: TestNG
- **Build Tool**: Maven
- **Dependency Management**: WebDriverManager
- **Version Control**: Git & GitHub

## 📂 Project Structure
```
Guru99AssignmentProject/
│-- src/
│   ├── main/
│   │   ├── java/guru99/pages/      # Page Object Model (POM) classes
│   │   ├── java/guru99/utils/      # Utility functions
│   ├── test/
│   │   ├── java/guru99_unit_tests/ # Test cases
│-- pom.xml                         # Maven dependencies
│-- testng.xml                       # TestNG suite configuration
│-- README.md                        # Project documentation
```

## ⚙️ Setup & Installation
### Prerequisites
Ensure you have the following installed:
- **Java 8+** ([Download here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
- **Maven** ([Install Guide](https://maven.apache.org/install.html))
- **Git** ([Download Git](https://git-scm.com/downloads))
- **Browser:** Mozilla Firefox

### Clone the Repository
```sh
git clone https://github.com/RamyaAK/Guru99AssignmentProject.git
cd Guru99AssignmentProject
```

### Install Dependencies
```sh
mvn clean install
```

## 🏃 Running Tests
### Using Maven
Run all test cases:
```sh
mvn test
```
Run tests with logs:
```sh
mvn test -Dlog.level=DEBUG
```

### Using TestNG
Run tests via TestNG XML configuration:
```sh
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

## 🛠 Test Execution Report
1. After running tests, find reports in:
   ```sh
   target/surefire-reports/
   ```
2. For **HTML Report**, install `ExtentReports` and integrate it.

## 🤝 Contribution Guidelines
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Push to your branch and create a PR.

## 🔥 Future Enhancements
- Add Negative Test Cases
- Integrate CI/CD with GitHub Actions
- Add Parallel Test Execution

## 📧 Contact
For any queries, reach out at [RamyaAK@github.com](mailto:RamyaAK@github.com).
