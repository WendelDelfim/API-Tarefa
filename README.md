<h1 align="center"> API Restful Tarefas - Wendel Delfim 💻</h1>


## 💻 Sobre

⚡Projeto feito no intuito de ser aprovado na matéria de Desenvolvimento Web Back-End.

👉 Essa API é um **gerenciador simples de tarefas** (To-Do List) que permite **registrar**, **consultar**, **alterar** e **excluir** tarefas, com **integração a banco de dados**, seguindo o **padrão RESTful**.

## 🗂️ A API é composta por:

**1. Camada de Modelo (Model Layer)** <br>
**Classe:** Tarefa <br>
Representa a **entidade** do banco de dados. <br>
É uma **tabela** chamada **Tarefa**, com os campos:
- **id** → chave primária (gerada automaticamente).
- **nome** → nome da tarefa.
- **dataEntrega** → data de entrega da tarefa.
- **responsavel** → quem é responsável pela tarefa.

---

**2. Camada de Repositório (Repository Layer)**
**Interface:** TarefaRepository
Extende JpaRepository <Tarefa, Long>.

É responsável pelo acesso ao banco de dados (CRUD automático).

Usa o Spring Data JPA + Hibernate para mapear os objetos Java para tabelas do MySQL.

3. Camada de Controle (Controller Layer)

Classe: TarefaController

Expõe os endpoints RESTful para o cliente:

GET /Tarefa → lista todas as tarefas.

GET /Tarefa/{id} → busca tarefa por ID.

POST /Tarefa → cria uma nova tarefa.

PUT /Tarefa/{id} → atualiza uma tarefa existente.

DELETE /Tarefa/{id} → remove uma tarefa.

4. Banco de Dados (Database Layer)

Banco: MySQL

Armazena todas as tarefas registradas.

O campo id é gerado automaticamente pela estratégia IDENTITY.

5. Configuração do Projeto (Build & Dependencies)

Arquivo: pom.xml

Tecnologias principais:

Spring Boot Starter Web → para criar a API REST.

Spring Boot Starter Data JPA → para persistência no banco.

MySQL Connector → para conectar ao banco MySQL.

Spring Boot Starter Test → para testes.

Spring Boot DevTools → para facilitar o desenvolvimento.
