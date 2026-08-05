# Bakery Common Messaging

The `bakery_common_messaging` library is a centralized shared module responsible for housing messaging contracts, event DTOs, Kafka topic constants, and Kafka configuration utilities across the **Blu's Bakery** microservices ecosystem.

---

## 1. Purpose

The primary purpose of this library is to enforce contract safety and schema consistency between microservices communicating over Apache Kafka. Key features include:

- **Standardized Base Event Schema**: Generic `BaseEvent<T>` providing common fields (`eventId`, `eventType`, `timestamp`, `metadata`, `payload`).
- **Domain Event & Payload Models**: Strongly-typed POJOs for asynchronous domain communication (Order, Payment, Product, User, Stock, Feedback, Review, Settings, Revenue).
- **Centralized Topic Constants**: Single source of truth for Kafka topic names (`KafkaTopics`).
- **Kafka Recovery & Error Handling**: Spring Kafka configuration (`KafkaConfig`) providing `DefaultErrorHandler` with `DeadLetterPublishingRecoverer` and fixed backoff retry logic.

---

## 2. Folder Structure

```text
bakery_common_messaging/
├── .github/
│   └── workflows/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
├── settings.gradle.kts
├── README.md
├── API_REFERENCE.md
└── src/
    └── main/
        ├── java/
        │   └── org/blubakery/common/messaging/
        │       ├── constants/
        │       │   └── KafkaTopics.java
        │       ├── contract/
        │       │   └── messaging/
        │       ├── event/
        │       │   └── BaseEvent.java
        │       ├── feedback/
        │       │   ├── FeedbackEvent.java
        │       │   └── FeedbackPayload.java
        │       ├── kafka/
        │       │   └── KafkaConfig.java
        │       ├── order/
        │       │   ├── OrderEvent.java
        │       │   └── OrderPayload.java
        │       ├── payment/
        │       │   ├── PaymentEvent.java
        │       │   ├── PaymentPayload.java
        │       │   ├── PaymentRequestedEvent.java
        │       │   └── PaymentRequestedPayload.java
        │       ├── product/
        │       │   ├── ProductEvent.java
        │       │   └── ProductPayload.java
        │       ├── revenue/
        │       │   └── RevenuePayload.java
        │       ├── review/
        │       │   ├── ReviewEvent.java
        │       │   └── ReviewPayload.java
        │       ├── settings/
        │       │   ├── SettingsEvent.java
        │       │   └── SettingsPayload.java
        │       ├── stock/
        │       │   ├── StockOperationRequestPayload.java
        │       │   └── StockOperationResponsePayload.java
        │       └── user/
        │           ├── UserEvent.java
        │           └── UserPayload.java
        └── resources/
```

---

## 3. Event-Driven Architecture Overview

In the Blu's Bakery microservices architecture, services communicate asynchronously via Kafka topics without tight coupling.

1. **Dependency Inclusion**: Services include `bakery_common_messaging` as a library dependency.
2. **Event Publishing**: Producers create domain events (e.g., `OrderEvent`, `PaymentRequestedEvent`), set payload fields, and publish them to topics defined in [`KafkaTopics`](file:///d:/dev_space/bakery/bakery_common_messaging/src/main/java/org/blubakery/common/messaging/constants/KafkaTopics.java).
3. **Event Consumption**: Consumers consume messages from defined Kafka topics and deserialize payloads back into strongly typed Java objects (`OrderPayload`, `PaymentPayload`, etc.).

---


## 🔗 Related Links

*For overall architecture, contribution guidelines, and security policies, please refer to the main [Blu's Bakery](https://github.com/amankrmj09/Blu_s_Bakery) repository.*

