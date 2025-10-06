<<<<<<< HEAD
# Demofront

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 20.3.3.

## Development server

To start a local development server, run:
=======
# GestaoDeEmpresasFullstack
# 🏢 Gestão de Empresas - Fullstack

Aplicação completa para **gestão de empresas**, composta por:

* **Frontend**: Angular 17 com busca, paginação e CRUD de empresas.
* **Backend**: Java 17 com Spring Boot, JPA/Hibernate e banco de dados MySQL.

---

## 🚀 Funcionalidades

* Cadastro, edição e exclusão de empresas.
* Listagem com paginação e filtro de busca.
* API REST no backend para CRUD de empresas.
* Integração frontend ↔ backend via HTTP.
* Persistência em banco de dados MySQL.

---

## 🖥️ Tecnologias

### Frontend

* Angular 17
* Ngx Pagination
* Bootstrap 5

### Backend

* Java 17
* Spring Boot 3
* Spring Data JPA / Hibernate
* MySQL 8
* Maven

---

## 📦 Instalação e execução

### 1. Backend (Java / Spring Boot)

Acesse a pasta do backend:

```bash
cd backend
```

Compile e execute:

```bash
./mvnw spring-boot:run
```

Ou via IDE (IntelliJ, Eclipse, VS Code com Extensão Java).

O backend estará disponível em:
👉 **[http://localhost:8080/api/empresas](http://localhost:8080/api/empresas)**

---

### 2. Banco de dados (MySQL)

Crie o banco de dados no MySQL:

```sql
CREATE DATABASE gestao_empresas;
```

Configure as credenciais em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/gestao_empresas
spring.datasource.username=root
spring.datasource.password=senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

### 3. Frontend (Angular)

Acesse a pasta do frontend:

```bash
cd frontend
```

Instale dependências:

```bash
npm install
```

Execute em modo desenvolvimento:
>>>>>>> 0aad1f6195f2ec8c0ff24874335517300ccf134b

```bash
ng serve
```

<<<<<<< HEAD
Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
ng generate --help
```

## Building

To build the project run:

```bash
ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.
=======
O frontend estará disponível em:
👉 **[http://localhost:4200/](http://localhost:4200/)**

---

## 📄 Estrutura do projeto

```
gestao-empresas/
│
├── backend/        # API REST em Java Spring Boot
│   ├── src/
│   ├── pom.xml
│   └── application.properties
│
├── frontend/       # Aplicação Angular 17
│   ├── src/
│   ├── package.json
│   └── angular.json
│
└── README.md
```

---

## 🛠️ Endpoints principais

* `GET /api/empresas` → Lista todas as empresas
* `GET /api/empresas/{id}` → Busca uma empresa por ID
* `POST /api/empresas` → Cria uma nova empresa
* `PUT /api/empresas/{id}` → Atualiza empresa existente
* `DELETE /api/empresas/{id}` → Remove empresa

---

## 🔐 Observações de segurança

* As senhas do banco devem ser configuradas em variáveis de ambiente em produção.
* Recomenda-se habilitar **MFA (Multi-Factor Authentication)** para usuários do sistema.
* Autenticação e autorização (Spring Security / JWT) podem ser adicionadas em versões futuras.

---

## 📜 Licença

Este projeto é distribuído sob a licença MIT.

Quer que eu detalhe também no README como o **formulário de cadastro/edição do Angular** consome a API do Spring Boot? Isso mostraria o ciclo completo do CRUD fullstack.

>>>>>>> 0aad1f6195f2ec8c0ff24874335517300ccf134b
