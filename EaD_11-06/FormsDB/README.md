# FormsDB - Sistema de Cadastro com Spring MVC

Sistema web desenvolvido em Java utilizando Spring MVC para cadastro e gerenciamento de produtos e clientes.

## Tecnologias Utilizadas

- Java
- Spring MVC
- Spring Data JPA
- JSP/JSTL
- Maven
- CSS

## Estrutura do Projeto

- **Controller**: Controladores para gerenciar requisições HTTP
- **Model**: Entidades do sistema (Cliente, Produto)
- **Repository**: Camada de acesso aos dados
- **Views**: Páginas JSP para interface do usuário

## Pré-requisitos

- Java 8 ou superior
- Apache Tomcat 9 ou superior
- Maven 3.6 ou superior

## Como Executar

### 1. Compilação e Deploy

1. **Compile o projeto com Maven**
   ```bash
   mvn clean compile
   ```

2. **Gere o arquivo WAR**
   ```bash
   mvn clean package
   ```
   - O arquivo `spring-mvc-forms-db.war` será gerado na pasta `target/`

3. **Deploy no Tomcat**
   - Copie o arquivo WAR para a pasta `webapps` do Tomcat:
   ```bash
   cp target/spring-mvc-forms-db.war [TOMCAT_HOME]/webapps/
   ```
   - Ou use o Tomcat Manager para fazer o deploy via interface web

### 2. Execução

1. **Inicie o Tomcat**
   - Windows: Execute `[TOMCAT_HOME]/bin/startup.bat`
   - Linux/Mac: Execute `[TOMCAT_HOME]/bin/startup.sh`

2. **Acesse a aplicação**
   - Abra o navegador e acesse: `http://localhost:8080/spring-mvc-forms-db/`

### 3. Verificação

- Se tudo estiver configurado corretamente, você verá a página inicial da aplicação
- As tabelas do banco de dados serão criadas automaticamente pelo JPA/Hibernate
- Teste as funcionalidades de cadastro de produtos e clientes

## Funcionalidades

- Cadastro de produtos
- Cadastro de clientes
- Listagem de registros
- Interface web responsiva
