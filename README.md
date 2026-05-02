# 🚀 Web API - Spring Boot + Security + JWT

## 📌 Overview

This project is a **RESTful Web API** built using **Spring Boot (Java 8)**. It integrates:

* 🔐 **Spring Security with JWT Authentication**
* 🗄️ **Hibernate (JPA) for ORM**
* 🐬 **MySQL Database**
* 📑 **Swagger (OpenAPI) for API Documentation**

The application provides secure, scalable, and production-ready backend services.

---

## 🛠️ Tech Stack

* **Java 8**
* **Spring Boot 2.x**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Spring Data JPA (Hibernate)**
* **MySQL**
* **Swagger (Springfox / OpenAPI)**
* **Maven**

---

## 📂 Project Structure

```id="proj1"
src/main/java/com/example/webapi
│
├── controller      # REST Controllers
├── service         # Business Logic Layer
├── repository      # JPA Repositories
├── entity          # Database Entities
├── security        # JWT & Security Config
├── config          # Swagger & App Config
└── exception       # Global Exception Handling

src/main/resources
├── application.properties
```

---

## 🔐 Security Features

* ✅ JWT-based Authentication
* ✅ Stateless Session Management
* ✅ Password Encryption using BCrypt
* ✅ Role-based Authorization
* ✅ Secure API endpoints

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository

```bash id="clone1"
git clone https://github.com/your-username/web-api.git
cd web-api
```

### 2️⃣ Configure MySQL Database

Update `application.properties`:

```properties id="mysql1"
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

---

### 3️⃣ Build the Project

```bash id="build1"
mvn clean install
```

---

### 4️⃣ Run the Application

```bash id="run1"
mvn spring-boot:run
```

Or run:

```bash id="run2"
Application.java
```

---

## 🔑 Authentication Flow (JWT)

1. User sends login request
2. Server validates credentials
3. JWT token is generated
4. Token is sent in response
5. Client sends token in headers:

```http id="jwt1"
Authorization: Bearer <your_token>
```

---

## 📡 API Endpoints (Sample)

### 🔓 Public APIs

| Method | Endpoint           | Description       |
| ------ | ------------------ | ----------------- |
| POST   | /api/auth/login    | Authenticate user |
| POST   | /api/auth/register | Register new user |

### 🔒 Protected APIs

| Method | Endpoint        | Description    |
| ------ | --------------- | -------------- |
| GET    | /api/users      | Get all users  |
| GET    | /api/users/{id} | Get user by ID |
| POST   | /api/users      | Create user    |
| PUT    | /api/users/{id} | Update user    |
| DELETE | /api/users/{id} | Delete user    |

---

## 📑 Swagger API Documentation

Access Swagger UI:

```
http://localhost:8080/swagger-ui/
```

Features:

* 📌 Interactive API testing
* 📌 Request/Response models
* 📌 Authorization support

---

## 🧱 Key Features

* ✅ RESTful API design
* ✅ Secure authentication with JWT
* ✅ Role-based access control
* ✅ Hibernate ORM with MySQL
* ✅ Centralized exception handling
* ✅ Swagger integration
* ✅ Clean layered architecture

---

## 🧪 Testing

```bash id="test1"
mvn test
```

---

## 📦 Build JAR

```bash id="jar1"
mvn clean package
```

Run:

```bash id="jar2"
java -jar target/web-api.jar
```

---

## 🧩 Future Enhancements

* 🔄 Refresh Token Implementation
* 🐳 Docker Support
* 📊 Logging & Monitoring (ELK / Prometheus)
* ☁️ Cloud Deployment (AWS / Azure)

---

## 🤝 Contribution

1. Fork the repository
2. Create a new branch (`feature/your-feature`)
3. Commit your changes
4. Push to GitHub
5. Create a Pull Request

---

## 📄 License

This project is licensed under the **MIT License**.

---

## 👨‍💻 Author

**Vineet Gupta**

---

## ⭐ Support

If you like this project:

* ⭐ Star the repository
* 👍 Share it with others

---
