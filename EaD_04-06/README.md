# Spring Boot JPA - Projeto Aluno-Curso

Este é um projeto Spring Boot que implementa um sistema de gerenciamento de alunos e cursos usando JPA/Hibernate.

## Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- MySQL Server rodando na porta 3306
- Banco de dados `testdb` criado no MySQL

## Configuração do Banco de Dados

### 1. Criar o banco de dados
```sql
CREATE DATABASE testdb;
```

### 2. Configurar usuário (se necessário)
```sql
-- Caso precise criar um usuário específico
CREATE USER 'root'@'localhost' IDENTIFIED BY 'sua_senha';
GRANT ALL PRIVILEGES ON testdb.* TO 'root'@'localhost';
FLUSH PRIVILEGES;
```

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/cursos/
│   │       ├── controller/
│   │       │   └── AlunoCursoController.java
│   │       ├── model/
│   │       │   ├── Aluno.java
│   │       │   └── Curso.java
│   │       ├── repository/
│   │       │   ├── AlunoRepository.java
│   │       │   └── CursoRepository.java
│   │       ├── service/
│   │       │   └── AlunoCursoService.java
│   │       └── SpringbootAlunoCursoApplication.java
│   └── resources/
│       └── application.properties
└── target/
```

## Configuração (application.properties)

O arquivo `src/main/resources/application.properties` deve conter:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui
spring.jpa.hibernate.ddl-auto=update
```

## Como Compilar e Executar

### 1. Limpar e Compilar o Projeto
```bash
mvn clean compile
```

### 2. Executar o Projeto
```bash
mvn spring-boot:run
```

## Testando a Aplicação

### 1. Endpoints Disponíveis

#### Alunos
- **GET** `/alunos` - Listar todos os alunos
- **GET** `/alunos/{id}` - Buscar aluno por ID
- **POST** `/alunos` - Criar novo aluno
- **PUT** `/alunos/{id}` - Atualizar aluno
- **DELETE** `/alunos/{id}` - Deletar aluno

#### Cursos
- **GET** `/cursos` - Listar todos os cursos
- **GET** `/cursos/{id}` - Buscar curso por ID
- **POST** `/cursos` - Criar novo curso
- **PUT** `/cursos/{id}` - Atualizar curso
- **DELETE** `/cursos/{id}` - Deletar curso