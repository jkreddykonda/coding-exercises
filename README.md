# Coding Exercises - Spring Boot Backend Application

This project is developed as part of a technical assessment, focusing on backend development using **Java 21**, **Spring Boot 3.4.5**, and **Maven**.

---

## 📂 Project Structure

- `controller/` ➔ Exposes REST APIs for Products, Payments, and Users.
- `services/` ➔ Handles business logic including async operations and currency conversions.
- `model/` ➔ Defines domain models like Product, Payment, and Currency types.
- `exception/` ➔ Centralized exception handling for consistent error responses.
- `utils/` ➔ Utility class for currency conversion logic.
- `test/` ➔ JUnit 5 tests for controller, service, utility, and exception handling layers.

---

## 🚀 Use Cases Implemented

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

## 🛠 Technologies Used

- Java 21
- Spring Boot 3.4.5
- Maven
- JUnit 5 + Mockito
- EclEmma (for test coverage check)

---

## 🧪 Test Coverage

- **Controllers**, **Services**, **Utilities**, and **Exception Handlers** are fully tested.
- **Overall project test coverage** is **above 90%**.
- Both **positive** and **negative** scenarios are covered.

---

## 📜 How to Run the Project

1. Ensure you have **Java 21** and **Maven** installed.
2. Clone the repository:

   ```bash
   git clone https://github.com/jkreddykonda/coding-exercises.git
   cd coding-exercises
   mvn clean install
   mvn spring-boot:run
