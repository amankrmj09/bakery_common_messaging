# Bakery Common Messaging

The `bakery_common_messaging` module is a shared library responsible for housing all centralized messaging contracts and utilities across the Bakery microservices ecosystem. 

## 1. Purpose

The primary purpose of this module is to ensure consistency and type safety across services communicating via message brokers (primarily Kafka). It encapsulates:
- **Shared Kafka Event Models/Classes**: Standardized POJOs/data classes representing domain events (e.g., `OrderPlacedEvent`, `PaymentProcessedEvent`).
- **Serializers and Deserializers**: Custom serialization logic (e.g., JSON, Avro) specifically tuned for the domain events to ensure messages can be safely produced and consumed.
- **Messaging Constants**: Shared constants like topic names, consumer group IDs, message headers, and partition keys to avoid hardcoded strings spread across various services.

By consolidating these elements, `bakery_common_messaging` creates a single source of truth for the event schemas, reducing duplication and integration issues between decoupled services.

## 2. Folder Structure

The project follows a standard Java/Gradle project structure:

```text
bakery_common_messaging/
├── build.gradle.kts       # Gradle build configuration
├── src/
│   └── main/
│       ├── java/org/blubakery/common/messaging/
│       │   ├── constants/ # Contains static constants (Topic names, group IDs)
│       │   ├── contract/  # Common messaging interfaces and base classes
│       │   ├── event/     # Data transfer objects (DTOs) representing the Kafka events
│       │   └── kafka/     # Serializers, deserializers, and Kafka configuration utilities
│       └── resources/     # Application configurations and static resources (if any)
```

## 3. Event-Driven Architecture Overview

The Bakery ecosystem relies heavily on an event-driven architecture (EDA). In this setup, services (such as `OrderService`, `PaymentService`, and `InventoryService`) communicate asynchronously without direct API calls. 

**How Services Use This Library:**
1. **Dependency Injection**: Microservices import the `bakery_common_messaging` artifact via their build tools (e.g., Maven or Gradle).
2. **Producers**: When a significant domain action occurs (e.g., an order is placed), the producing service instantiates the corresponding event class from the `event` package. It then serializes it using the provided serializers from the `kafka` package and publishes it to the appropriate topic defined in the `constants` package.
3. **Consumers**: Subscribing services listen to the predefined topics. Upon receiving a message, they use the library's deserializers to accurately cast the message payload back into the strongly-typed event class, enabling seamless downstream processing.

This approach guarantees that both producers and consumers adhere strictly to the same schema, thereby avoiding contract drift and deserialization errors.

## 4. Defining a New Event Payload

To introduce a new domain event into the ecosystem, follow these steps:

1. **Create the Event Class**:
   Navigate to `src/main/java/org/blubakery/common/messaging/event/` and define a new class. It should preferably implement a common base event interface (if one exists in `contract`) and include standard fields (e.g., `eventId`, `timestamp`, `correlationId`).
   ```java
   public class NewFeatureTriggeredEvent {
       private String eventId;
       private String featureData;
       private Instant timestamp;
       // Getters, Setters, and Constructors
   }
   ```

2. **Define Constants**:
   Add the new topic name (and any specific headers or consumer groups) to the appropriate class in the `constants` package.
   ```java
   public static final String NEW_FEATURE_TOPIC = "bakery.events.new-feature";
   ```

3. **Configure Serialization (If Needed)**:
   If your new event requires custom serialization rules (e.g., date formatting, specific Jackson annotations), apply them within the event class or update the common serializers in the `kafka` package.

4. **Publish a New Version**:
   Increment the version in `build.gradle.kts` (or `gradle.properties`) and publish the library to the internal artifact repository.

5. **Update Microservices**:
   Consumer and producer microservices should bump their dependency version to the newly published version of `bakery_common_messaging` to start utilizing the new event payload.
