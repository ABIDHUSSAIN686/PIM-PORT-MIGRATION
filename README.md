# PIM Port Migration

A robust data migration service designed to extract, transform, and load product-related data (swatches, collections, collection types, and brands) from a Cassandra-backed PIM (Product Information Management) system into a PostgreSQL-based Port service. Built using Spring Boot and Apache Camel, this service ensures efficient, scalable, and modular ETL workflows suitable for microservices environments.

---

## Overview

**PIM Port Migration** automates the flow of critical product data from a distributed NoSQL source (Cassandra) to a relational PostgreSQL target. The application uses Apache Camel for routing and transformation, and integrates with Kafka for asynchronous processing and messaging.

This service ensures data consistency across systems and supports operations like initial migrations, incremental updates, and re-syncs.

---

## Architecture

- **Source**: Cassandra (PIM)  
- **Destination**: PostgreSQL (Port Service)  
- **ETL Framework**: Apache Camel  
- **Transport**: Kafka  
- **Framework**: Spring Boot (v2.7.5)  
- **Language**: Java 17  
- **Monitoring**: Prometheus (Micrometer)

## Tech Stack

- Spring Boot 2.7.5  
- Java 17  
- Apache Camel 4.0.0  
- Kafka  
- PostgreSQL  
- Cassandra  
- Lombok  
- Micrometer + Prometheus  
- ModelMapper  
- JPA (Hibernate)

---

## Modules

- `pim-application`: PIM-side data fetch logic  
- `port-application`: Port-side data storage logic  
- `pim-domain` / `port-domain`: Domain models for each service  
- `pim-common`: Shared utilities and transformers

### Prerequisites

- Java 17  
- Gradle  
- Docker (for PostgreSQL and Cassandra)  
- Kafka (via Docker or Confluent)

### Clone the Repo

```bash
git clone https://github.com/ABIDHUSSAIN686/PIM-PORT-MIGRATION
cd pim-port-migration
```
