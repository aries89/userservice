# User Service

## Overview
The User Service is responsible for managing user accounts, authentication, and authorization within the E-Commerce Microservices System.

## Responsibilities
- User registration and profile management

## Technology Stack
- Java 21
- Spring Boot
- Spring Security
- Spring Data JPA
- PostgreSQL

## Running Locally
1. Clone the repository:
```bash
git clone https://github.com/aries89/userservice.git
2.	Build and run:
mvn spring-boot:run
Endpoints
•	POST /api/users - Register a new user
•	GET /users/{id} - Fetch user details
Future Enhancements
•	Assignment of roles to users
•	JWT Authentication
