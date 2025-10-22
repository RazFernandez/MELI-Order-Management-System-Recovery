# meli-ecommerce API

This is a Spring Boot REST API for managing an e-commerce system. It provides full CRUD (Create, Read, Update, Delete) operations for Customers, Products, and Orders.

## Core Technologies
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- Maven
- PostgreSQL (Production)
- H2 Database (Development)

## Environments & Setup

This application uses Spring Profiles to manage database configurations. The active profile can be set in `src/main/resources/application.properties`.

### Development (dev)
- **Profile:** dev
- **Database:** H2 (In-Memory)

To use: Set `spring.profiles.active=dev` in `application.properties`.

**H2 Console:** Once running, the H2 console is available at [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

**JDBC URL:** `jdbc:h2:mem:meli-ecommerce`

### Production (prod)
- **Profile:** prod
- **Database:** PostgreSQL

To use: Set `spring.profiles.active=prod` in `application.properties`.

Configuration: You must set your database credentials in `src/main/resources/application-prod.properties` before running.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/meli-ecommerce
spring.datasource.username=YOUR_POSTGRES_USERNAME
spring.datasource.password=YOUR_POSTGRES_PASSWORD
spring.jpa.hibernate.ddl-auto=validate
```

---

## API Endpoint Documentation
All endpoints are prefixed with `/api`.

### 👤 Customer Resource
**Base URL:** `/api/customers`

#### 1. Create a New Customer
**Method:** POST  
**Endpoint:** `/api/customers`  
**Description:** Creates a new customer.

**Example Body (JSON):**
```json
{
    "name": "Carlos Ramirez",
    "email": "carlos@example.com",
    "password": "1234"
}
```

**Example (curl):**
```bash
curl -X POST http://localhost:8080/api/customers \
-H "Content-Type: application/json" \
-d '{
    "name": "Carlos Ramirez",
    "email": "carlos@example.com",
    "password": "1234"
}'
```

#### 2. Get All Customers
**Method:** GET  
**Endpoint:** `/api/customers`  
**Description:** Retrieves a list of all customers.

```bash
curl http://localhost:8080/api/customers
```

#### 3. Get a Single Customer by ID
**Method:** GET  
**Endpoint:** `/api/customers/{id}`  
**Description:** Retrieves a specific customer by their ID.

```bash
curl http://localhost:8080/api/customers/1
```

#### 4. Update an Existing Customer
**Method:** PUT  
**Endpoint:** `/api/customers/{id}`  
**Description:** Updates an existing customer's details.

**Example Body (JSON):**
```json
{
    "name": "Carlos Ramirez (Updated)",
    "email": "carlos.new@example.com",
    "password": "new_password"
}
```

#### 5. Delete a Customer
**Method:** DELETE  
**Endpoint:** `/api/customers/{id}`  
**Description:** Deletes a customer by their ID.

```bash
curl -X DELETE http://localhost:8080/api/customers/1
```

---

### 📦 Product Resource
**Base URL:** `/api/products`

#### 1. Create a New Product
**Method:** POST  
**Endpoint:** `/api/products`  
**Description:** Creates a new product.

**Example Body (JSON):**
```json
{
    "name": "Wireless Mouse",
    "description": "Ergonomic mouse",
    "unit_price": 299.99,
    "stock": 100
}
```

#### 2. Get All Products
```bash
curl http://localhost:8080/api/products
```

#### 3. Get a Single Product by ID
```bash
curl http://localhost:8080/api/products/1
```

#### 4. Update an Existing Product
**Example Body (JSON):**
```json
{
    "name": "Wireless Mouse (Black)",
    "description": "Ergonomic mouse",
    "unit_price": 309.99,
    "stock": 95
}
```

#### 5. Delete a Product
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

---

### 🧾 Order Resource
**Base URL:** `/api/orders`

**Prerequisite:** You must have existing Customer and Product IDs to create an order.

#### 1. Create a New Order
**Method:** POST  
**Endpoint:** `/api/orders`  
**Description:** Creates a new order.

**Example Body (JSON):**
```json
{
    "status": "Pending",
    "totalAmount": 1058.99,
    "customer": {
        "customerId": 1
    },
    "orderItems": [
        {
            "quantity": 1,
            "subtotal": 799.50,
            "product": {
                "productId": 1
            }
        },
        {
            "quantity": 1,
            "subtotal": 259.49,
            "product": {
                "productId": 2
            }
        }
    ]
}
```

#### 2. Get All Orders
```bash
curl http://localhost:8080/api/orders
```

#### 3. Get a Single Order by ID
```bash
curl http://localhost:8080/api/orders/1
```

#### 4. Update an Existing Order
**Example Body (JSON):**
```json
{
    "status": "Shipped"
}
```

#### 5. Delete an Order
```bash
curl -X DELETE http://localhost:8080/api/orders/1
```
---

## Postman Documentation:
Postamn APIs Structure
</br>
</br>
<img width="333" height="638" alt="image" src="https://github.com/user-attachments/assets/2e1f283d-ee82-478c-91e9-e284a4a87226" />

### Customer CRUD operations
#### Create customer
<img width="1788" height="1018" alt="image" src="https://github.com/user-attachments/assets/19bd74d9-864e-4546-a8c0-da30debe8c23" />

#### Get customer by ID
<img width="1812" height="1016" alt="image" src="https://github.com/user-attachments/assets/5f187867-f6b2-44e2-b977-234e85ee4a1a" />

#### Get all customers
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/ec8788e5-c44e-4650-9734-781ebcd5b761" />

#### Update customer
<img width="1919" height="1015" alt="image" src="https://github.com/user-attachments/assets/9fc6c70c-f1c7-4e44-95c7-5393af739fab" />

#### Delete customer
<img width="1811" height="942" alt="image" src="https://github.com/user-attachments/assets/f4e0fdf5-499d-4216-a29d-2377eeb05d25" />

### Products CRUD operations
#### Create product
<img width="1785" height="1011" alt="image" src="https://github.com/user-attachments/assets/b4bf5089-67ff-4154-94fb-7596d0698317" />


#### Get product by ID
<img width="1919" height="1079" alt="image" src="https://github.com/user-attachments/assets/faab92cc-4442-4481-92d6-f184a21d6f58" />


#### Get all products
<img width="1808" height="1023" alt="image" src="https://github.com/user-attachments/assets/df71d1fd-2a60-4f40-a26e-6a8a6b5b643b" />


#### Update product
<img width="1796" height="1015" alt="image" src="https://github.com/user-attachments/assets/cf16fdc6-5dfc-40a2-bb8b-ace24d9a44ac" />


#### Delete product
<img width="1808" height="1019" alt="image" src="https://github.com/user-attachments/assets/7b0335d9-3d1c-4b02-bb21-541f1cdbaef1" />

### Orders CRUD operations
#### Create order
<img width="1822" height="1099" alt="image" src="https://github.com/user-attachments/assets/e1f3544b-9f52-4012-a76b-0903c48e6f59" />


#### Get order by ID
<img width="1482" height="1091" alt="image" src="https://github.com/user-attachments/assets/826c2bae-486d-46ed-a36d-485d04a876ce" />



#### Get all orders
<img width="1484" height="1081" alt="image" src="https://github.com/user-attachments/assets/69c94bab-f42f-4b51-88c2-e09658eccc95" />



#### Update order
<img width="1483" height="1118" alt="image" src="https://github.com/user-attachments/assets/9330e385-7b9a-4396-a97c-72cd28ab2621" />



#### Delete order
<img width="1476" height="1085" alt="image" src="https://github.com/user-attachments/assets/8311162d-c031-4ea9-a4a6-3a6cd4eb9d9c" />



---

## PostgreSQL evidence:
#### Customers
<img width="643" height="703" alt="image" src="https://github.com/user-attachments/assets/d2dfed23-1aeb-44a2-a125-4bd6e8fb9e9b" />

#### Products
<img width="746" height="773" alt="image" src="https://github.com/user-attachments/assets/4f93ffe7-6f7b-4465-a458-db2e60a4f5ab" />

#### Orders
<img width="705" height="782" alt="image" src="https://github.com/user-attachments/assets/e0322963-65ab-4401-ac9b-a90ba2d4c93a" />




