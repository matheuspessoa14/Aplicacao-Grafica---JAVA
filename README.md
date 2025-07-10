# 📌 Projeto: Sistema de Gestão de Eventos (Java + Swing + MySQL)

Este projeto consiste em um sistema de **cadastro, consulta e atualização de eventos** com interface gráfica desenvolvida em **Java Swing** e persistência de dados em **MySQL**.

O sistema permite gerenciar:
- **Eventos**, com nome, data, local, descrição e vínculo com organizadores.
- **Participantes** de eventos.
- **Organizadores**, responsáveis pelos eventos cadastrados.

A interface gráfica foi construída com **Java Swing**, seguindo boas práticas de separação entre a camada de apresentação (interface), lógica de negócio e acesso ao banco de dados (DAO). O banco de dados utilizado é o **MySQL**, com integração via JDBC.

---

## 🔧 Tecnologias utilizadas

- **Java 8+**
- **Java Swing (GUI)**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **XAMPP** (como ambiente local de testes)

## ⚙️ Funcionalidades

- ✅ Consultar evento por ID
- ✅ Atualizar ou cadastrar novo evento
- ✅ Interface intuitiva com validações básicas
- ✅ Relacionamento entre Evento e Organizador com chave estrangeira

---

## 🗃️ Banco de Dados

- Nome do banco: `gestao_eventos`
- Tabelas principais:
  - `evento`
  - `organizador`
  - `participante`

**Importante:** Certifique-se de cadastrar previamente os organizadores antes de vincular um evento ao `id_organizador`, pois a tabela de eventos possui uma **chave estrangeira** que depende disso.

---

## 🚀 Como executar o projeto

1. Clone este repositório.
2. Importe o projeto em uma IDE como Eclipse ou IntelliJ.
3. Certifique-se de que o MySQL está rodando com o banco `gestao_eventos` criado.
4. Execute a classe `TesteSwing.java` para abrir o menu inicial.

---

## 👤 Autor

Matheus Pessoa Telles de Oliveira  
💻 Estudante de Análise e Desenvolvimento de Sistemas  
🚀 Apaixonado por desenvolvimento de sistemas e interfaces gráficas em Java

---


