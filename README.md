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
  
---
## ⚙️ Funcionalidades

- ✅ Consultar evento por ID
- ✅ Atualizar ou cadastrar novo evento
- ✅ Interface intuitiva com validações básicas
- ✅ Relacionamento entre Evento e Organizador com chave estrangeira
