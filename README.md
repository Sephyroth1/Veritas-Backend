# Payroll Management System

A full-stack payroll management backend built with **Spring Boot** that enables organizations to manage employees, configure salary structures, execute payroll, and maintain secure audit trails.

At the heart of the application is a custom-built payroll engine that compiles salary formulas into an optimized execution plan. Rather than hardcoding calculations, payroll rules are expressed using a small domain-specific language (DSL), allowing complex salary structures to be configured without changing application code.

---

# Features

## Payroll Management

* Employee management
* Department and designation management
* Salary structure management
* Payroll processing
* Payroll history
* Configurable salary components
* Formula-based payroll calculations

## Security

* User authentication
* Role-based authorization
* Protected REST APIs
* Secure password handling

## Audit & Monitoring

* Audit logging
* Business event tracking
* Payroll execution history

## Technical Features

* Custom payroll DSL
* Pratt parser
* Abstract Syntax Tree (AST)
* Dependency graph construction
* Cycle detection
* Topological sorting
* Immutable execution plans
* RESTful APIs
* PostgreSQL persistence
* Docker support

---

# Technology Stack

| Category         | Technology                  |
| ---------------- | --------------------------- |
| Language         | Java 21                     |
| Framework        | Spring Boot                 |
| Security         | Spring Security             |
| ORM              | Spring Data JPA / Hibernate |
| Database         | PostgreSQL                  |
| Build Tool       | Gradle                      |
| Containerization | Docker                      |
| API              | REST                        |

---

# System Architecture

```text
                   Clients
                      │
             REST Controllers
                      │
             Business Services
        ┌─────────────┴─────────────┐
        │                           │
 Payroll Management          Payroll Engine
        │                           │
        └─────────────┬─────────────┘
                      │
              Spring Data JPA
                      │
                 PostgreSQL
```

The application follows a layered architecture where business operations such as employee management and payroll processing are separated from the payroll rule engine.

---

# Payroll Engine

One of the core components of this project is a compiler-inspired payroll engine.

Salary calculations are defined using formulas instead of hardcoded Java logic.

Example:

```text
Basic = INPUT
HRA = Basic * 0.40
Allowance = Basic * 0.10
Gross = Basic + HRA + Allowance
PF = Gross * 0.12
Net = Gross - PF
```

The engine compiles these rules through the following pipeline:

```text
Rules
   │
Lexer
   │
Parser
   │
AST
   │
Dependency Graph
   │
Cycle Detection
   │
Topological Sort
   │
Execution Plan
   │
Payroll Evaluation
```

The execution plan is compiled once and reused to evaluate payroll efficiently for multiple employees.

---

# Why This Project?

Most payroll systems hardcode salary calculations directly in application code, making rule changes difficult and error-prone.

This project separates payroll logic from business logic by introducing a dedicated rule engine. The engine validates salary formulas, detects dependency cycles, determines execution order, and evaluates payroll deterministically. This approach makes the system easier to extend and maintain as payroll policies evolve.

---

# Future Improvements

* Kafka event publishing
* Transactional Outbox pattern
* Rule versioning
* Payroll simulation
* Formula debugger
* Execution plan caching
* Multi-tenant support
* Reporting & analytics
