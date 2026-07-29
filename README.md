# 📨 Bakery Common Messaging

![Java](https://img.shields.io/badge/Java-21%2B-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)

Welcome to **Bakery Common Messaging**, the asynchronous event-driven architecture package of the Shah's Bakery Microservice Platform.

## 🎯 Purpose
This module manages the shared event schemas and configurations for message brokers, ensuring that all microservices publish and consume events using a strongly-typed, consistent format.

## 🛠️ Features
- **Shared Event Models**: Common event definitions for inter-service messaging.
- **Serialization Utilities**: Common Kafka/RabbitMQ serialization/deserialization configurations.
- **Domain Events**: Standardized payloads like `OrderCreatedEvent`, `PaymentProcessedEvent`, etc.

## 📁 Folder Structure
```text
src/
└── main/
    └── java/org/blubakery/common/messaging/
        ├── event/      # Shared event models (e.g., OrderEvent, PaymentEvent).
        └── config/     # Common messaging configurations.
```

## 🚀 Getting Started

### Local Setup
1. Include this library in your service's `build.gradle.kts`:
   ```kotlin
   implementation("org.blubakery.libs:bakery_common_messaging:1.0.0")
   ```

## 🔗 Related Links
- [Main Platform README](../README.md)
