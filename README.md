# Service Zero

Service Zero is a minimal, production-oriented Java service designed as a foundation for modern backend systems.

It demonstrates:

- clean architecture with a framework-free core
- dual entry points (HTTP API + CLI)
- Java 21 with Gradle Kotlin DSL
- container-first thinking using Docker

This project is intentionally small. Its purpose is correctness, clarity, and extensibility.

## Architecture

The codebase is structured around a simple principle:

> The core contains behavior. Interfaces adapt it.

### Modules

- `core/`  
  Domain logic and use cases. No Spring or framework dependencies.

- `api/`  
  HTTP interface built with Spring Boot. Thin controllers only.

- `cli/`  
  Command-line interface for introspection and admin-style commands.

- `config/`  
  Dependency wiring and framework boundaries.

This structure allows new interfaces (gRPC, messaging, AI agents) to be added without rewriting the core.

## Running Locally

### Prerequisites

- Java 21
- Docker (optional)

### Run via Gradle

```bash
./gradlew bootRun
```

### Test endpoints

```bash
curl http://localhost:8080/info
curl http://localhost:8080/actuator/health

curl http://localhost:8080/info
curl http://localhost:8080/actuator/health
```

## Docker Usage

The service uses a multi-stage Docker build to produce a small runtime image.

### Build image

```bash
docker build -t service-zero:0.0.1 .
```

### Run container

```bash
docker run -p 8080:8080 service-zero:0.0.1
```

## Design Decisions

- **No database**  
  This project focuses on service structure, not persistence.

- **No Spring annotations in core**  
  Keeps the domain portable and testable.

- **Manual CLI wiring**  
  Avoids framework overhead for non-server use cases.

- **Java 21**  
  Chosen for modern language features and long-term support.

These decisions are intentional and documented to make future evolution predictable.

## Future Extensions

Service Zero is designed to grow incrementally:

- persistence (PostgreSQL)
- security (OAuth2 / mTLS)
- messaging (Kafka / queues)
- native builds (GraalVM)
- AI-assisted interfaces (Python services, LLM tooling)

Each addition will preserve the core-first architecture.