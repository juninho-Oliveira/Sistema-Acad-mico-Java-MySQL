# 🎓 Sistema Acadêmico — Java + MySQL

## 📚 Sobre o Projeto

Este projeto foi desenvolvido em grupo com o objetivo de criar um sistema acadêmico desktop utilizando Java Swing integrado ao banco de dados MySQL.

O sistema permite realizar o gerenciamento de alunos, cursos, notas, faltas e boletins acadêmicos, aplicando conceitos de Programação Orientada a Objetos, CRUD, integração com banco de dados e interface gráfica.

---

# 🚀 Funcionalidades

## 👨‍🎓 Cadastro de Alunos

* Salvar alunos
* Consultar alunos
* Alterar cadastro
* Excluir alunos

## 📝 Notas e Faltas

* Cadastro de notas
* Cadastro de faltas
* Consulta de notas
* Alteração de notas
* Exclusão de notas

## 📄 Boletim

* Consulta de boletim acadêmico
* Exibição de:

  * Nome
  * Curso
  * Disciplina
  * Nota
  * Faltas
  * Semestre

---

# 💻 Tecnologias Utilizadas

* Java
* Java Swing
* MySQL
* JDBC
* Eclipse IDE

---

# 🗄️ Banco de Dados

O sistema utiliza banco de dados MySQL com relacionamento entre tabelas utilizando:

* PRIMARY KEY
* FOREIGN KEY
* ON DELETE CASCADE

---

# 🧠 Conceitos Aplicados

* Programação Orientada a Objetos
* CRUD
* Integração Java + MySQL
* PreparedStatement
* Interface Gráfica com Swing
* Tratamento de exceções
* Validação de campos
* Relacionamento entre tabelas

---

# 📷 Interface do Sistema

## Tela Principal

Adicione aqui uma imagem da interface do sistema.

```md
![Tela do Sistema](./imagens/tela.png)
```

---

# ⚙️ Como Executar o Projeto

## 1️⃣ Clonar o repositório

```bash
git clone LINK_DO_REPOSITORIO
```

---

## 2️⃣ Criar o banco de dados MySQL

```sql
CREATE DATABASE sistema_academico;

USE sistema_academico;

CREATE TABLE alunos (
    rgm VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    data_nascimento VARCHAR(10),
    cpf VARCHAR(14),
    email VARCHAR(100),
    endereco VARCHAR(150),
    municipio VARCHAR(80),
    uf VARCHAR(2),
    celular VARCHAR(15),
    curso VARCHAR(100),
    campus VARCHAR(50),
    periodo VARCHAR(20)
);

CREATE TABLE notas_faltas (

    id INT AUTO_INCREMENT PRIMARY KEY,

    rgm VARCHAR(20),

    disciplina VARCHAR(100),

    semestre VARCHAR(20),

    nota VARCHAR(10),

    faltas INT,

    FOREIGN KEY (rgm)
    REFERENCES alunos(rgm)

    ON DELETE CASCADE
);
```

---

## 3️⃣ Configurar conexão com MySQL

Verifique a classe:

```java
Conexao.java
```

E altere:

* usuário
* senha
* porta do MySQL

---

## 4️⃣ Executar o Projeto

Abra o projeto no Eclipse e execute:

```java
TelaSistemaAcademico.java
```

---

# 👥 Integrantes do Grupo

* Damião Júnior
* Integrante 2
* Integrante 3
* Integrante 4

---

# 📌 Observações

Este projeto possui finalidade acadêmica e foi desenvolvido para prática de:

* Java
* Banco de Dados
* CRUD
* Interface gráfica
* Integração com MySQL
