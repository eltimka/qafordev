# REST API for "Developer-Level Testing".

## Technologies:
* Java 21
* Spring Boot 3
* Spring Web
* Spring Data
* Lombok
* JUnit
* Mockito
* PostgreSQL
* Embedded DB H2
* Testcontainers

# Branch: STEP 1

## Description:
Creating a correct project structure (entity, repository).
Basic Configuration

# Branch: STEP 2
## Description:
Added tests for the repository layer using:
* @DataJpaTest annotations
* H2 database

# Branch: STEP 3
## Description:
Added a service layer with the application's business logic
Added unit tests for the service layer using Mockito

# Branch: STEP 4
## Description:
Added unit tests for the controller layer using:
* Mockito
* @WebMvcTest annotations
* MockMvc object

# Branch: STEP 5
## Description:
Added integration tests for the controller layer using:
* local PostgreSQL database
* @SpringBootTest annotations

# Branch: STEP 6
## Description:
Added and applied configuration for Test containers