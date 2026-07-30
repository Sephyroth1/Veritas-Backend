# Payroll Engine

A compiler-inspired payroll rule engine built in Java.

Instead of hardcoding salary calculations, payroll components are defined using a small domain-specific language (DSL). The engine parses the rules, validates them, builds a dependency graph, determines a safe evaluation order, and computes the final values.

---

## Features

* Custom payroll DSL
* Lexer
* Pratt Parser
* Abstract Syntax Tree (AST)
* Visitor-based architecture
* Semantic analysis

  * Undefined identifier detection
* Dependency graph generation
* Circular dependency detection
* Topological sorting
* Expression evaluation using `BigDecimal`

---

## Example

```text
Basic = INPUT
HRA = Basic * 0.40
DA = Basic * 0.20
Gross = Basic + HRA + DA
PF = Gross * 0.12
Net = Gross - PF
```

Given

```text
INPUT = 50000
```

The engine evaluates

```text
Basic = 50000
HRA = 20000
DA = 10000
Gross = 80000
PF = 9600
Net = 70400
```

---

## Compiler Pipeline

```text
Payroll Rules
      │
      ▼
+-------------+
|    Lexer    |
+-------------+
      │
      ▼
+-------------+
| Pratt Parser|
+-------------+
      │
      ▼
+-------------+
|     AST     |
+-------------+
      │
      ▼
+----------------------+
| Semantic Analysis    |
| • Undefined symbols  |
+----------------------+
      │
      ▼
+----------------------+
| Dependency Graph     |
+----------------------+
      │
      ▼
+----------------------+
| Cycle Detection      |
+----------------------+
      │
      ▼
+----------------------+
| Topological Sort     |
+----------------------+
      │
      ▼
+----------------------+
| Expression Evaluator |
+----------------------+
      │
      ▼
Computed Payroll Values
```

---

## Language

Each payroll component is defined as an assignment.

```text
Component = Expression
```

Expressions may contain:

* Numeric literals
* Identifiers
* Parentheses
* Unary operators
* Binary operators

Example

```text
Basic = INPUT
HRA = Basic * 0.40
PF = Basic * 0.12
Net = Basic + HRA - PF
```

---

## Architecture

### Lexer

Converts source code into tokens.

Example

```text
Basic = INPUT * 0.4
```

becomes

```text
IDENTIFIER
EQUAL
IDENTIFIER
STAR
NUMBER
EOF
```

---

### Parser

A Pratt parser is used to construct the Abstract Syntax Tree.

Example

```text
Gross = Basic + HRA
```

becomes

```text
Assign
 ├── Gross
 └── +
     ├── Basic
     └── HRA
```

---

### Semantic Analysis

The semantic phase validates the program after parsing.

Current checks include:

* Undefined identifiers

Future checks:

* Duplicate definitions
* Type checking
* Constant validation

---

### Dependency Graph

Each payroll component becomes a node.

Example

```text
Gross = Basic + HRA
```

creates

```text
Gross ─────► Basic
      └────► HRA
```

The graph is used for dependency analysis and evaluation ordering.

---

### Cycle Detection

Circular payroll definitions are rejected.

Example

```text
A = B
B = A
```

Results in a compilation error instead of infinite recursion.

---

### Topological Sort

The dependency graph is transformed into an evaluation order.

For

```text
Basic = 50000
HRA = Basic * 0.40
Gross = Basic + HRA
```

the evaluation order is

```text
Basic
HRA
Gross
```

ensuring every dependency is available before it is referenced.

---

### Evaluation

Expressions are evaluated using `BigDecimal` to avoid floating-point inaccuracies.

Values are stored in a lookup table during evaluation.

```text
Basic → 50000
HRA   → 20000
Gross → 70000
```

---

## Project Structure

```text
src
└── main
    └── java
        ├── lexer
        ├── parser
        ├── ast
        ├── visitor
        ├── semantic
        ├── graph
        ├── evaluator
        └── util
```

---

## Current Status

### Implemented

* Lexer
* Pratt parser
* AST
* Visitor pattern
* Semantic analysis
* Dependency graph
* Cycle detection
* Topological sorting
* Evaluation engine

### Planned

* Rich compiler diagnostics
* Custom exception hierarchy
* REST API
* PostgreSQL persistence
* Docker deployment
* Additional payroll functions
* Comprehensive unit testing

---

## Motivation

Most payroll systems embed business rules directly in application code, making them difficult to modify and maintain. This project explores a compiler-based approach where payroll rules are treated as a small programming language.

By separating parsing, validation, dependency analysis, and evaluation, payroll logic becomes easier to extend, verify, and maintain.

---

## License

TBD
