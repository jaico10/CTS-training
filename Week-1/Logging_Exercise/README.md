# SLF4J Logging Exercise

This project demonstrates logging messages at the `ERROR` and `WARN` levels using SLF4J with Logback.

---

## Logging Concepts

### What is SLF4J?
**SLF4J** (Simple Logging Facade for Java) is a logging abstraction layer. It serves as a simple facade for various logging frameworks (such as java.util.logging, logback, log4j). It allows developers to write logging statements using SLF4J's API, while the actual implementation framework (like Logback) can be configured or swapped at deployment time without modifying source code.

### What is Logback?
**Logback** is the direct successor to the popular log4j project. It implements the SLF4J API natively, which makes log statements routed through SLF4J execute with zero memory and computational overhead.

### Logging Levels
Logging frameworks organize log entries by severity level:
1. **TRACE:** Fine-grained informational events, most verbose.
2. **DEBUG:** Informational events useful to debug an application.
3. **INFO:** General operational progress messages.
4. **WARN:** Potentially harmful situations (warnings).
5. **ERROR:** Error events that might allow the application to continue running, but represent incorrect behavior.

In [LoggingExample.java](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Logging_Exercise/src/main/java/com/example/LoggingExample.java), we log messages at the `ERROR` and `WARN` levels:
```java
logger.error("This is an error message");
logger.warn("This is a warning message");
```

---

## Project Dependencies

Dependencies are managed in [pom.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Logging_Exercise/pom.xml):
```xml
<!-- SLF4J API -->
<dependency> 
    <groupId>org.slf4j</groupId> 
    <artifactId>slf4j-api</artifactId> 
    <version>1.7.30</version> 
</dependency> 

<!-- Logback Classic -->
<dependency> 
    <groupId>ch.qos.logback</groupId> 
    <artifactId>logback-classic</artifactId> 
    <version>1.2.3</version> 
</dependency>
```

---

## Log Formatting Configuration

Logback formatting is configured in [logback.xml](file:///c:/Users/jaico/Downloads/Java_FSE_Training-main/Java_FSE_Training-main/Week-1/Logging_Exercise/src/main/resources/logback.xml):
* Appends logs directly to the Standard Console (`System.out`).
* Includes details like timestamp, executing thread name, log level, logger name (usually the class name), and the message.
```xml
<pattern>%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
```
