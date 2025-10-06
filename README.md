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

```bash
ng serve
```

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

