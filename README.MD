# Gestão de Vagas

Este projeto é um sistema de gerenciamento de vagas de emprego, implementado com Spring Boot. Ele permite a criação, autenticação e gerenciamento de candidatos e empresas, bem como a publicação e busca de vagas.

## Configuração do Ambiente

### Requisitos
- Java 11+
- MySQL

### Configuração do Banco de Dados

Certifique-se de que o MySQL está em execução e crie um banco de dados chamado `gestao_vagas`. Atualize o arquivo `application.properties` com as credenciais do banco de dados:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestao_vagas
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update

security.token.secret=JAVAGAS_@123#
```
### Instalação
1. Clone o repositório:
```
git clone https://github.com/tsilva19/gestaovagas.git
cd gestaovagas
```

2. Compile e execute o projeto:

```
./mvnw spring-boot:run
```

## Endpoints da API
### Autenticação
1. Autenticar Empresa `POST /auth/company`:
    
   - Request Body:
       ```
        {
         "username": "company_username",
         "password": "company_password"
        }
       ```

   - Response:
     - 200 OK: Retorna o token JWT.
     - 401 Unauthorized: Credenciais inválidas.

### Candidatos
1. Criar Candidato `POST /candidate/`:

    - Request Body:
        ```
         {
            "username": "candidate_username",
            "email": "candidate_email",
            "password": "candidate_password",
            "name": "candidate_name",
            "description": "candidate_description",
            "curriculum": "candidate_curriculum"
         }
        ```

    - Response:
        - 200 OK: Retorna o objeto do candidato criado.
        - 400 Bad Request: Erro de validação ou usuário já existe.

### Empresas
1. Criar Empresa `POST /company/`:

    - Request Body:
        ```
         {
            "username": "company_username",
            "email": "company_email",
            "password": "company_password",
            "website": "company_website",
            "name": "company_name",
            "description": "company_description"
         }
        ```

    - Response:
        - 200 OK: Retorna o objeto da empresa criada.
        - 400 Bad Request: Erro de validação ou usuário já existe.


2. Criar Vaga `POST /job/`:

    - Request Header:
        ```
         Authorization: Bearer {JWT_TOKEN}
        ```
    - Request Body:
        ```
         {
           "description": "job_description",
           "benefits": "job_benefits",
           "level": "job_level"
         }

        ```

    - Response:
        - 200 OK: Retorna o objeto da vaga criada.
        - 401 Unauthorized: Token inválido ou não fornecido.

## Estrutura de Design Patterns

- DTO (Data Transfer Object): Usado para transferir dados entre camadas da aplicação (AuthCompanyDTO, CreateJobDTO).
- Service Layer: Contém a lógica de negócios principal (CreateCandidateUseCase, CreateCompanyUseCase, AuthCompanyUseCase).
- Repository Pattern: Interface para a persistência de dados (CandidateRepository, CompanyRepository, JobRepository).
- Exception Handling: Tratamento centralizado de exceções (ExceptionHandlerController, UserFoundException).

## Tecnologias Utilizadas

- Spring Boot: Framework principal para a construção da aplicação.
- Spring Data JPA: Para a interação com o banco de dados.
- Spring Security: Para a segurança e gestão de autenticação.
- JWT (JSON Web Token): Para autenticação baseada em token.