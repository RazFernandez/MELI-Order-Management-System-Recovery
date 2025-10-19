# 🛍️ MELI E-commerce — Entity-Relationship Model Documentation

## 📘 Overview
This document describes the **Entity-Relationship (ER) model** designed for the **MELI E-commerce platform**, which manages customer accounts, product listings, and orders.  
The model defines the main entities, their attributes, and how they relate to each other to represent the order management process.

---

<img width="882" height="611" alt="Challenge-5-ER drawio" src="https://github.com/user-attachments/assets/553123d7-dee7-431c-bb07-27406f62e0f4" />]

</br>
<img width="1023" height="520" alt="image" src="https://github.com/user-attachments/assets/d3a11e70-bf88-4a7e-b92b-44ed305fa8c3" />


## 🧱 Entities and Attributes

### 👤 **Customer**
Represents users who create accounts and place orders in the MELI platform.

| Attribute | Description |
|------------|-------------|
| **Customer_Id (PK)** | Unique identifier for each customer. |
| **Name** | Full name of the customer. |
| **Email** | Customer’s contact email, also used for login. |
| **Password** | Encrypted password for authentication. |

**Notes:**
- A **Customer** can create multiple orders.
- Acts as the primary entity for identifying users in the system.

---

### 🧾 **Order**
Represents a single purchase made by a customer. Each order can contain one or more products.

| Attribute | Description |
|------------|-------------|
| **Order_Id (PK)** | Unique identifier for the order. |
| **Date** | The date when the order was created. |
| **Status** | Indicates the order’s current state (e.g., Pending, Shipped, Delivered). |
| **Total Amount** | The total price of all products included in the order. |
| **Customer_Id (FK)** | References the customer who created the order. |

**Notes:**
- Every **Order** belongs to one **Customer**.
- Each **Order** can contain multiple **Products** through the **Has** relationship.

---

### 📦 **Product**
Represents an item available for purchase in the online store.

| Attribute | Description |
|------------|-------------|
| **Product_Id (PK)** | Unique identifier for each product. |
| **Name** | Product name. |
| **Description** | Short text describing the product’s features. |
| **Unit Price** | Price per unit of the product. |
| **Stock** | Quantity available in inventory. |

**Notes:**
- A **Product** can appear in multiple orders.
- Linked to the **Order** entity through the **Has** relationship.

---

### 🧩 **OrderItem**
Acts as a **junction table** that links **Orders** and **Products** to implement the Many-to-Many relationship.

| Attribute | Description |
|------------|-------------|
| **OrderItem_Id (PK)** | Unique identifier for each record in the junction table. |
| **Order_Id (FK)** | References the order associated with the item. |
| **Product_Id (FK)** | References the product included in the order. |
| **Quantity** | Number of units of the product in this order. |
| **Subtotal** | Calculated field (Quantity × Product Unit Price). |

**Notes:**
- Each **OrderItem** record represents one product within a specific order.
- Ensures flexibility for orders containing multiple products with variable quantities.

---

### 🔗 **Relationships**

#### 1️⃣ Customer — Order (`creates`)
- **Type:** One-to-Many (1:N)  
- **Description:** A customer can create multiple orders, but each order belongs to exactly one customer.  
- **Example:** One user can place several orders over time.

#### 2️⃣ Order — Product (`has` through OrderItem)
- **Type:** Many-to-Many (M:N)  
- **Description:** An order can contain multiple products, and a product can appear in multiple orders.  
- **Attributes in Relationship (OrderItem Table):**
  - **Quantity:** Number of units of a product in a specific order.  
  - **Subtotal:** Total for that specific product quantity.  

---

## 🧩 Summary of Relationships

| Relationship | Entities Involved | Type | Description |
|---------------|------------------|------|--------------|
| **creates** | Customer → Order | 1:N | One customer can create many orders. |
| **has** | Order ↔ Product (via OrderItem) | M:N | An order can contain many products; a product can appear in many orders. |

---

## 🧠 Conceptual Flow

1. **Customers** register and log in.  
2. They **create Orders** that store date, status, and total amount.  
3. Each **Order** includes one or more **Products** through the **OrderItem** table.  
4. **Products** maintain stock levels and pricing for real-time availability.
5. The **OrderItem** table allows flexibility in defining product quantities and prices per order.

---
