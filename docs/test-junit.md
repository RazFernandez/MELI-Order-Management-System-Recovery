# 🧪 Controller CRUD Tests – MELI App

This document explains the purpose, importance, and structure of the **JUnit tests** implemented for the controllers of the **MELI Order Management System**.  
These tests ensure that the application's API endpoints for `Customer`, `Product`, and `Order` controllers function correctly following **Spring Boot 3.x** conventions.

---

## 📘 Overview

This testing suite validates the **CRUD (Create, Read, Update, Delete)** operations for the three main entities in the system:

- 👤 **CustomerController**
- 📦 **ProductController**
- 🧾 **OrderController**

Each controller test uses `@SpringBootTest` and `@AutoConfigureMockMvc` to simulate HTTP requests to the REST endpoints, verifying:
- That the endpoints return correct **HTTP status codes** (`201`, `200`, `204`, etc.).
- That entities are correctly **serialized/deserialized**.
- That invalid operations are properly **handled** with appropriate responses.

---

## ⚙️ Technologies Used

- **Java 17+**
- **Spring Boot 3.x**
- **JUnit 5 (Jupiter)**
- **Spring MockMvc**
- **H2 Database (in-memory testing)**

---

## 🧩 Test Classes

| Test File | Description |
|------------|-------------|
| `CustomerControllerTest.java` | Tests all endpoints under `/api/customers`. |
| `ProductControllerTest.java` | Tests all endpoints under `/api/products`. |
| `OrderControllerTest.java` | Tests all endpoints under `/api/orders`. |

Each file follows this basic structure:

```java
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldCreateCustomerSuccessfully() throws Exception {
        // Example test for POST /api/customers
    }

    @Test
    void shouldReturnAllCustomers() throws Exception {
        // Example test for GET /api/customers
    }

    // ... etc.
}
```

---

## 🧠 Why Testing Matters

Automated testing is a critical part of modern backend development.  
It helps ensure:
1. ✅ **Reliability** – Detects regressions before deployment.  
2. ⚡ **Efficiency** – Saves time by catching logic or configuration issues early.  
3. 🔄 **Maintainability** – Makes refactoring safer by ensuring existing functionality isn’t broken.  
4. 🧰 **Confidence in Deployment** – You can push updates knowing your API behaves as expected.

> A well-tested backend increases code quality and guarantees stable integration between your services, controllers, and database layers.

---

## 🖼️ Test Results

Below are screenshots demonstrating successful CRUD test execution.

### 🧩 1. CustomerController Tests
*(Insert your screenshot here)*  
<img width="1635" height="1029" alt="image" src="https://github.com/user-attachments/assets/80c54c33-fd39-420b-9fa3-45191e2b19fb" />


### 📦 2. ProductController Tests
*(Insert your screenshot here)*  
<img width="1630" height="902" alt="image" src="https://github.com/user-attachments/assets/46967ee3-ed56-4043-969d-e68ad933ee99" />


### 🧾 3. OrderController Tests
*(Insert your screenshot here)*  
<img width="1644" height="819" alt="image" src="https://github.com/user-attachments/assets/ff24d82c-858b-495c-a0f5-624097ff625c" />


---

## 🚀 How to Run Tests

### From Terminal (Maven)
```bash
mvn test
```

### From VS Code or IntelliJ IDEA
Right-click on the `src/test/java/com/meli/meli_app` folder  
→ Select **"Run Tests"** or **"Run All Tests with Coverage"**

---

## 🧩 Folder Structure

```
src/
 ├── main/
 │    └── java/
 │         └── com/meli/meli_app/
 │              ├── controller/
 │              ├── model/
 │              ├── repository/
 │              └── service/
 └── test/
      └── java/
           └── com/meli/meli_app/
                ├── CustomerControllerTest.java
                ├── ProductControllerTest.java
                └── OrderControllerTest.java
```

---

## 💬 Final Notes

- Keep tests **independent** — each should be self-contained and not depend on another test’s state.
- When adding new features (like search, pagination, or filtering), always include new test cases.
- Use **MockMvc** for REST endpoint testing and **@DataJpaTest** for repository-level tests.

> “Testing isn’t about finding bugs — it’s about preventing them.” 🧩

---
