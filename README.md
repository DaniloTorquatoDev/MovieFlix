# MovieFlix

API RESTful em **Java** com **Spring Boot** para gerenciamento de catálogo de filmes, categorias e serviços de streaming.

---

## Tecnologias & Dependências

- Java 
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Flyway
- Lombok
- Validação de dados (`@Valid`)
- SpringDoc OpenAPI / Swagger

---

## Como executar

###  Pré-requisitos
- Java X
- Maven
- Banco de dados (ou Docker Compose)

### Passos
```bash
git clone https://github.com/DaniloTorquatoDev/MovieFlix.git
cd MovieFlix
# configurar application.properties
# (opcional: docker-compose up -d)
./mvnw spring-boot:run
```
Acesse a API em: `http://localhost:8080`

## Documentação da API

Acesse a interface interativa via Swagger em:
`http://localhost:8080/swagger-ui.html`

## Endpoints Disponíveis
### Categorias
| Método | Endpoint         | Descrição            |
| ------ | ---------------- | -------------------- |
| GET    | /categories      | Listar todas         |
| GET    | /categories/{id} | Obter por ID         |
| POST   | /categories      | Criar nova categoria |
| DELETE | /categories/{id} | Excluir categoria    |

### Streaming
| Método | Endpoint        | Descrição             |
| ------ | --------------- | --------------------- |
| GET    | /streaming      | Listar todos          |
| GET    | /streaming/{id} | Obter por ID          |
| POST   | /streaming      | Criar nova plataforma |
| DELETE | /streaming/{id} | Excluir plataforma    |

### Filmes
| Método | Endpoint                | Descrição                    |
| ------ | ----------------------- | ---------------------------- |
| GET    | /movies                 | Listar todos os filmes       |
| GET    | /movies/{id}            | Obter filme por ID           |
| POST   | /movies                 | Criar novo filme             |
| PUT    | /movies/{id}            | Atualizar filme              |
| DELETE | /movies/{id}            | Excluir filme                |
| GET    | /movies?categoryId={id} | Filtrar filmes por categoria |



