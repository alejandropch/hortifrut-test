---

# Full Stack App - HortiFrut Test

This project contains:

- **Frontend** → Next.js (React + Zustand + TanStack Query)
- **Backend** → Spring Boot API
- **Dockerized** for development and production

---

## How to run the thing?

To start **both frontend and backend** locally using Docker, run this command **from the root of the repository**:


```bash
docker compose -f docker-compose.dev.yml up --build
```
---
## Backend Architecture Overview

Even though this project clearly doesn't need it, I still used good practices and design patterns. Here are my architectural decisions:

- **DDD (Domain-Driven Design)**: Models core business concepts clearly, separating domain logic from infrastructure and application concerns.  
- **Hexagonal Architecture (Ports & Adapters)**: Isolates the domain and application layers from external systems such as databases, web APIs, and caches, improving testability and maintainability.  
- **CQRS (Command Query Responsibility Segregation)**: Separates commands (writes) from queries (reads), allowing independent optimization, scaling, and clear responsibility for each operation.  
- **Query Bus**: Implements a mediator pattern to decouple query requests from their handlers, making the system modular and extensible.  
- **Cache**: Uses an in-memory cache to reduce outgoing requests to the external Pokémon API (`https://pokeapi.co/`), improving response times and reducing external load.

### Why these patterns?

- **DDD + Hexagonal** keep business rules clean and the codebase easy to evolve.  
- **CQRS + Query Bus** make query operations explicit, type-safe, and testable.  
- **In-memory caching** prevents repeated external API calls for the same Pokémon data or paginated lists.

---


