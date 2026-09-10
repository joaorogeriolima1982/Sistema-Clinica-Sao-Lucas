# 🏥 Clínica São Lucas

Sistema desktop para gerenciamento de uma clínica médica, desenvolvido em
Java Swing com integração ao banco de dados PostgreSQL.

O projeto foi desenvolvido com foco em organização do código, separação de
responsabilidades, segurança, validação de dados e gerenciamento eficiente
das conexões com o banco de dados.

---

## 📌 Sobre o projeto

O sistema permite o gerenciamento de:

- Usuários
- Pacientes
- Médicos
- Consultas
- Histórico de consultas

O acesso ao banco de dados é realizado através de **JDBC**, utilizando
**HikariCP** para gerenciamento do pool de conexões.

**🔐 Segurança**

O projeto possui mecanismos para proteção de informações sensíveis.

Entre os recursos implementados estão:

- Criptografia AES
- Proteção das credenciais de acesso ao banco de dados
- Criptografia da URL de conexão
- Criptografia do usuário do banco
- Criptografia da senha do banco
- Senha de autorização para cadastro de novos usuários
- Utilização de PreparedStatement
- Validação dos dados antes da persistência

---

# 🎯 Funcionalidades

## 🔐 Autenticação e usuários

- Tela de login
- Validação de usuário e senha
- Cadastro de novos usuários
- Senha de autorização para cadastro
- Validação de campos obrigatórios
- Proteção das informações sensíveis através de criptografia

![Demonstração do sistema](Tela-de-Login.gif)

---

## 👤 Gerenciamento de pacientes

- Cadastro de pacientes
- Edição de pacientes
- Exclusão de pacientes
- Pesquisa de pacientes por nome
- Exibição dos pacientes em JTable
- Validação de CPF
- Validação de telefone
- Validação de e-mail
- Validação de campos obrigatórios
- Impedimento de exclusão de paciente que possui consulta cadastrada

![Demonstração do sistema](Tela-de-Pacientes.gif)

---

## 👨‍⚕️ Gerenciamento de médicos

- Cadastro de médicos
- Edição de médicos
- Exclusão de médicos
- Pesquisa de médicos por nome
- Exibição dos médicos em JTable
- Validação de telefone
- Validação de e-mail
- Validação de campos obrigatórios
- Impedimento de exclusão de médico que possui consulta cadastrada

![Demonstração do sistema](Tela-de-Medicos.gif)

---

## 📅 Gerenciamento de consultas

- Cadastro de consultas
- Edição de consultas
- Exclusão de consultas
- Pesquisa por nome
- Pesquisa por data
- Associação entre paciente e médico
- Exibição das consultas em JTable

![Demonstração do sistema](Tela-de-Consultas.gif)

---

## 📋 Histórico de consultas

- Visualização do histórico de consultas
- Pesquisa por nome
- Pesquisa por data
- Exclusão de registros
- Exibição dos dados através de JTable

![Demonstração do sistema](Tela-de-Historico.gif)

---

# 🛠️ Tecnologias utilizadas

- **Java**
- **Java Swing**
- **JDBC**
- **PostgreSQL**
- **HikariCP**
- **Criptografia AES**
- **Caelum Stella**
- **Google libphonenumber**
- **NetBeans**

---

# 🏗️ Arquitetura

O projeto foi organizado em camadas para separar as responsabilidades da
aplicação.

```text
┌──────────────────────────┐
│          VIEW            │
│     Interface gráfica    │
│        Java Swing        │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│         SERVICE          │
│     Regras de negócio    │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│           DAO            │
│     Acesso aos dados     │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│         HIKARICP         │
│   Pool de conexões JDBC  │
└────────────┬─────────────┘
             │
             ▼
┌──────────────────────────┐
│        POSTGRESQL        │
│       Banco de dados     │
└──────────────────────────┘

---

## ⚙️ Configuração

# Requisitos

Para executar o projeto é necessário possuir:

- Java JDK
- PostgreSQL
- NetBeans ou outra IDE compatível
- Driver JDBC do PostgreSQL

# Banco de dados

- Instale o PostgreSQL.
- Crie o banco de dados da aplicação.
- Execute o script SQL do projeto.
- Configure os parâmetros de conexão.
- Configure as chaves necessárias para a criptografia.
- Execute a aplicação.


## 📚 Objetivos do projeto

Este projeto foi desenvolvido com o objetivo de aplicar conhecimentos
práticos de desenvolvimento de software utilizando Java.

# Entre os conhecimentos aplicados estão:

- Programação orientada a objetos
- Desenvolvimento de interfaces gráficas
- Arquitetura em camadas
- JDBC
- SQL
- PostgreSQL
- CRUD
- Connection Pool
- HikariCP
- Criptografia
- Validação de dados
- Tratamento de exceções
- Organização de código


## 👨‍💻 Autor

#João Rogério de Lima

Tecnólogo em Análise e Desenvolvimento de Sistemas.
