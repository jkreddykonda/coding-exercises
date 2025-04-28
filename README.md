# Coding Exercises - Spring Boot Backend Application

This project is developed as part of a technical assessment, focusing on backend development using **Java 21**, **Spring Boot 3.4.5**, and **Maven**.

---

## Project Structure

- `controller/` ➔ Exposes REST APIs for Products, Payments, and Users.
- `services/` ➔ Handles business logic including async operations and currency conversions.
- `model/` ➔ Defines domain models like Product, Payment, and Currency types.
- `exception/` ➔ Centralized exception handling for consistent error responses.
- `utils/` ➔ Utility class for currency conversion logic.
- `test/` ➔ JUnit 5 tests for controller, service, utility, and exception handling layers.

---

## Use Cases Implemented

### 1.1 - Product Category Average Pricing (Stream API)
- Accepts a list of Products via REST API.
- Groups products by category.
- Calculates the average price per category using Java Streams.

### 1.2 - Payment Currency Conversion (Records and Pattern Matching)
- Accepts a Payment request.
- Converts payment amount to a target currency.
- Uses Java 17 Records and Sealed Types for Currency models.
- Simulates predefined exchange rates.

### 1.3 - User Data Fetching (CompletableFuture and Async)
- Fetches user data asynchronously from two sources.
- Combines the results after both async operations complete.
- Handles cases where user IDs are invalid gracefully.

---

## Technologies Used

- Java 21
- Spring Boot 3.4.5
- Maven
- JUnit 5 + Mockito
- EclEmma (for coverage check)

---

## Test Coverage

- **Controllers**, **Services**, **Utilities**, and **Exception Handlers** are tested.
- **Overall project test coverage** is **above 90%**.
- Both **positive** and **negative** test scenarios are handled.
  
---

## How to Run the Project

1. Ensure you have **Java 21** and **Maven** installed.
2. Clone or unzip the project.
3. Open the project in any IDE (e.g., Eclipse, IntelliJ IDEA).
4. Run the following command:

```bash
mvn spring-boot:run
