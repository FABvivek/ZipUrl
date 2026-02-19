# 🔗 ZipUrl — Secure URL Shortener with JWT Authentication

ZipUrl is a Spring Boot–based URL Shortener API with JWT authentication, user-based URL ownership, and click tracking analytics.

It allows users to:

- Register & Login securely
- Generate shortened URLs
- Redirect to original URLs
- Track click events
- Manage their own URLs

---

## 🚀 Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- RESTful APIs
- H2 / MySQL (configurable)

---

## 🏗 Architecture Overview

```
Controller Layer
    ↓
Service Layer
    ↓
Repository Layer
    ↓
Database
```

### 📂 Project Structure

```
controller/
    AuthController
    UrlMappingController
    RedirectController

service/
    UserService
    UrlMappingService

repository/
    UserRepository
    UrlMappingRepository
    ClickEventRepository

security/
    WebSecurityConfig
    JwtAuthenticationFilter
    JwtUtils
    UserDetailsImpl
    UserDetailsServiceImpl

model/
    User
    UrlMapping
    ClickEvent

dto/
    LoginRequest
    RegisterRequest
    UrlMappingDTO
    ClickEventDTO
    JwtAuthenticationResponse
```

---

## 🔐 Authentication Flow

1. User registers.
2. User logs in.
3. Server generates JWT token.
4. Client sends JWT in header:

```
Authorization: Bearer <your_token>
```

5. JwtAuthenticationFilter validates token.
6. User is authenticated for protected endpoints.

---

## 📡 API Endpoints

### 🔑 Authentication

### Register
**POST** `/api/auth/register`

Request:
```json
{
  "username": "vivek",
  "email": "vivek@email.com",
  "password": "password123"
}
```

---

### Login
**POST** `/api/auth/login`

Request:
```json
{
  "username": "vivek",
  "password": "password123"
}
```

Response:
```json
{
  "token": "jwt_token_here",
  "type": "Bearer"
}
```

---

## 🔗 URL Management

### Create Short URL
**POST** `/api/urls`

Headers:
```
Authorization: Bearer <jwt_token>
```

Request:
```json
{
  "originalUrl": "https://google.com"
}
```

Response:
```json
{
  "shortCode": "aB12x",
  "originalUrl": "https://google.com",
  "createdAt": "timestamp"
}
```

---

### Get All URLs for Logged-in User
**GET** `/api/urls`

Headers:
```
Authorization: Bearer <jwt_token>
```

Returns all URLs created by the authenticated user.

---

## 🔁 Redirect Endpoint

**GET** `/{shortCode}`

- Redirects to the original URL.
- Records click event.
- Tracks timestamp and metadata.

Example:
```
GET http://localhost:8080/aB12x
```

---

## 🗄 Database Schema Overview

### User
- id
- username
- email
- password
- roles

### UrlMapping
- id
- originalUrl
- shortCode
- createdAt
- user (ManyToOne relationship)

### ClickEvent
- id
- timestamp
- ipAddress
- urlMapping (ManyToOne relationship)

---

## ⚙️ Running the Project

### 1️⃣ Clone Repository

```
git clone https://github.com/FABvivek/ZipUrl.git
cd ZipUrl
```

### 2️⃣ Configure Database

Edit `application.properties`:

For H2 (in-memory):
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.jpa.hibernate.ddl-auto=update
```

For MySQL:
```
spring.datasource.url=jdbc:mysql://localhost:3306/zipurl
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

---

### 3️⃣ Run Application

Using Maven:

```
mvn spring-boot:run
```

Or run main class from IDE.

Application runs at:

```
http://localhost:8080
```

---

## 🧪 Testing with Postman

1. Register user
2. Login → Copy JWT
3. Add JWT in Authorization header
4. Create short URL
5. Open short URL in browser to test redirect

---

## 📈 Features

- JWT-based stateless authentication
- Secure password encryption
- URL ownership
- Click analytics
- Layered architecture
- Clean RESTful API design

---

## 🔮 Future Improvements

- Custom short code support
- URL expiration
- Role-based access control
- Analytics dashboard
- Rate limiting
- Docker support
- Production deployment configuration

---

---
