
---

````markdown
# Time Deposit API

A Spring Boot application to manage time deposits and withdrawals for different plan types: **Basic**, **Student**, and **Premium**. Each plan applies a different interest rate and logic.

---

## 🛠 Tech Stack

- Java 17  
- Spring Boot 3.5  
- Spring Data JPA  
- H2 In-Memory Database  
- RESTful API  
- Lombok  
- JUnit + Mockito  

---

## 📊 Plan Types & Interest Rules

| Plan Type | Interest Rate | Special Conditions                     |
|-----------|---------------|----------------------------------------|
| Basic     | 1% monthly     | Only if days > 30                      |
| Student   | 3% monthly     | only for deposits > 30 && deposits ≤ 1 year    |
| Premium   | 5% monthly     | Interest starts after 45 days          |

---

## 🚀 Running the Application

```bash
./mvnw spring-boot:run
````

> The application starts on `http://localhost:8080`

---

## 🔗 REST APIs

### 🔍 Get All Time Deposits

```
GET /api/v1/time-deposits
```

**Response:**

```json
[
  {
    "id": 1,
    "planType": "basic",
    "days": 60,
    "balance": 1000.00,
    "withdrawals": [
      {
        "id": 1,
        "amount": 200.00,
        "date": "2024-12-12"
      }
    ]
  }
]
```
**Example Request:**

```bash
curl -X GET http://localhost:8080/api/v1/time-deposits \
-H "Accept: application/json"
```
---


### API: Calculate All Time Deposit Balances

`PUT /calculate-balance`

**Response:**

* **204 No Content**: Successfully recalculated and updated all balances.
* **500 Internal Server Error**: An error occurred while processing the request.

**Example Request:**

```bash
curl -X PUT http://localhost:8080/api/v1/time-deposits/calculate-balance
```

**Notes:**

* This operation updates balances for all deposits in the system.
* The recalculation logic depends on the plan type rules (e.g., Basic, Student, Premium).

---



## 🧪 Running Tests

```bash
./mvnw test
```

---

## 📁 H2 Database Console

Visit: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

* **JDBC URL:** `jdbc:h2:mem:time_deposit`
* **Username:** `ikigai`
* **Password:** *(leave blank)*

---

