# Order Tracker Kafka Simulation

A simplified **Real-Time Order Tracking System** built with Spring Boot that simulates Kafka-like behavior for order status updates.  
This project demonstrates how orders progress through different statuses automatically, mimicking message consumption in Kafka with scheduled tasks.

---

## 🚀 Project Overview

This application simulates the process of updating order statuses in real-time using Spring Boot scheduling, without actually using Kafka.  
Orders transition through these statuses:

- **PLACED** → **PROCESSING** → **SHIPPED** → **DELIVERED**

Every 5 seconds, the system automatically updates order statuses and logs these changes to simulate Kafka consumer processing.

---

## 🧰 Technologies Used

- Java 17  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
- Maven  
- Scheduling with `@Scheduled` annotation  
- SLF4J & Logback for logging  

---

## ⚙️ Features

- REST API to **create** new orders (`POST /orders`)  
- REST API to **fetch** order status (`GET /orders/{id}`)  
- Automatic order status updates every 5 seconds via scheduled tasks  
- Kafka-style log simulation to trace order status transitions  
- Database persistence with PostgreSQL  

---

## 📦 Getting Started

### Prerequisites

- Java 17+  
- Maven  
- PostgreSQL (running and configured)  

### Setup

1. Clone the repo:

   ```bash
   git clone https://github.com/YOUR_USERNAME/order-tracker-kafka-simulation.git
   cd order-tracker-kafka-simulation
2. Configure PostgreSQL connection
   ```bash
    spring:
     datasource:
       url: jdbc:postgresql://localhost:5432/your_database
       username: your_username
       password: your_password
3. Build and run the application
4. Use swagger to test

### Output

#Logs

![image](https://github.com/user-attachments/assets/ba87058d-b1c8-4a16-9b5f-52ec6daac981)

#Swagger

![image](https://github.com/user-attachments/assets/67eedaca-4d6e-4fc9-a7c5-648cf90c0132)

