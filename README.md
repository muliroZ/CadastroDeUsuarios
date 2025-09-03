# 🚀 Cadastro de Usuários

[![Java](https://img.shields.io/badge/Java-21-orange)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen)](https://spring.io/projects/spring-boot)
[![Maven](https://img.shields.io/badge/Maven-3.9.0-blue)](https://maven.apache.org/)
[![H2 Database](https://img.shields.io/badge/H2-In%20Memory-lightgrey)](https://www.h2database.com/)

Uma API REST simples para cadastro e gerenciamento de usuários, desenvolvida com Spring Boot. Este projeto demonstra boas práticas de desenvolvimento em Java, incluindo validação de dados, tratamento de exceções e integração com banco de dados H2 em memória.

## 📋 Índice

- [Funcionalidades](#-funcionalidades)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação e Execução](#-instalação-e-execução)
- [Uso da API](#-uso-da-api)
- [Documentação da API](#-documentação-da-api)
- [Banco de Dados](#-banco-de-dados)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Contribuição](#-contribuição)
- [Licença](#-licença)

## ✨ Funcionalidades

- **Cadastro de Usuários**: Adicione novos usuários com validação de nome e email.
- **Consulta de Usuários**: Busque usuários por nome, email ou substring.
- **Listagem Completa**: Obtenha todos os usuários cadastrados.
- **Validação de Dados**: Garante que nome e email sejam fornecidos e email seja único.
- **Tratamento de Exceções**: Respostas adequadas para erros como usuário não encontrado ou email duplicado.
- **Banco de Dados H2**: Persistência em memória para desenvolvimento e testes.

## 🛠 Tecnologias Utilizadas

- **Java 21**: Linguagem de programação principal.
- **Spring Boot 3.5.5**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Spring Web**: Para criação de endpoints REST.
- **H2 Database**: Banco de dados em memória para desenvolvimento.
- **Lombok**: Para redução de código boilerplate.
- **Maven**: Gerenciamento de dependências e build.
- **Spring Boot Actuator**: Para monitoramento da aplicação.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **Java 21** ou superior.
- **Maven 3.6+** para gerenciamento de dependências.
- Um IDE como IntelliJ IDEA, Eclipse ou VS Code (opcional, mas recomendado).

## 🚀 Instalação e Execução

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/muliroZ/cadastrodeusuarios.git
   cd cadastrodeusuarios
   ```

2. **Compile o projeto**:
   ```bash
   mvn clean compile
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

   Ou, se preferir usar o wrapper Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

A aplicação estará rodando em `http://localhost:8080`.

## 📖 Uso da API

Após iniciar a aplicação, você pode testar os endpoints usando ferramentas como Insomnia, Postman, curl ou diretamente no navegador.

### Exemplo de Requisição

**Adicionar um usuário**:
```bash
curl -X POST http://localhost:8080/api/users/add \
  -H "Content-Type: application/json" \
  -d '{"nome": "João Silva", "email": "joao@example.com"}'
```

## 📚 Documentação da API

### Endpoints Disponíveis

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/users` | Lista todos os usuários |
| GET | `/api/users/name/{name}` | Busca usuário por nome exato |
| GET | `/api/users/find?name={substring}` | Busca usuários por substring no nome |
| GET | `/api/users/email/{email}` | Busca usuário por email |
| POST | `/api/users/add` | Adiciona um novo usuário |

### Modelos de Dados

**User**:
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao@example.com"
}
```

### Códigos de Status

- `200 OK`: Requisição bem-sucedida.
- `201 Created`: Usuário criado com sucesso.
- `204 No Content`: Nenhum usuário encontrado.
- `400 Bad Request`: Dados inválidos.
- `404 Not Found`: Usuário não encontrado.
- `409 Conflict`: Email já existe.

## 🗄 Banco de Dados

O projeto utiliza H2 Database em memória para facilitar o desenvolvimento e testes.

- **Console H2**: Acesse `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:cadusers`
- **Username**: `sa`
- **Senha**: (vazio)

## 📁 Estrutura do Projeto

```
cadastrodeusuarios/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/muriloscorp/cadastrodeusuarios/
│   │   │       ├── CadastroDeUsuariosApplication.java
│   │   │       ├── controller/
│   │   │       │   ├── RestExceptionHandler.java
│   │   │       │   └── UserController.java
│   │   │       ├── exceptions/
│   │   │       │   └── EmailAlreadyExistsException.java
│   │   │       ├── model/
│   │   │       │   └── User.java
│   │   │       ├── repository/
│   │   │       │   └── UserRepository.java
│   │   │       └── service/
│   │   │           └── UserService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/
│           └── com/muriloscorp/cadastrodeusuarios/
│               └── CadastroDeUsuariosApplicationTests.java
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## 🤝 Contribuição

Contribuições são bem-vindas! Siga estes passos:

1. Fork o projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`).
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`).
4. Push para a branch (`git push origin feature/AmazingFeature`).
5. Abra um Pull Request.

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

Feito por [Murilo Andrade](https://github.com/muliroZ)
