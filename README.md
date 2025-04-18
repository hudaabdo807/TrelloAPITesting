# Trello_API_UsingRset-assured

This project is an API testing framework built using Java, REST Assured, Maven, and TestNG for testing Trello's API. It provides a comprehensive suite of tests covering various scenarios, ensuring the reliability and functionality of interactions with Trello's API endpoints.


Key Features
---
REST Assured Framework: Utilizes the powerful REST Assured framework to streamline API testing in Java.
TestNG Approach: Implements TestNG for test execution and reporting, allowing for easy organization and management of tests.
Multiple Independent Tests: The framework includes multiple independent tests, each verifying different aspects of Trello's API functionality.
Scenario Validation: Covers different scenarios for GET, POST, PUT, and DELETE requests, ensuring thorough validation of API endpoints.
Class-based Requests: Each API request is encapsulated in a separate class, promoting modularity and maintainability.
Server Availability Check: Before executing each test, the framework verifies server availability with a ping request.
Logging via Log4j: Implements logging functionality using Log4j to capture and analyze test execution details.
Valid Assertions: Includes valid assertions in all tests to ensure accurate validation of API responses.
Negative Scenario Validation: Validates negative scenarios to ensure robust error handling and graceful degradation.
Payload Separation: Avoids keeping payloads in test scripts to maintain separation of concerns and enhance readability.
Extent Reports: Implements Extent reports for comprehensive and visually appealing test reports.

Usage
---
Clone the repository to your local machine.
Ensure you have Java and Maven installed.
Navigate to the project directory.
Run mvn test to execute the test suite.
Review the generated Extent reports for detailed test results.
