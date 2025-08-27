package com.example.API_Tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API_Tarefas.model.Tarefa;

@Repository																				//Marca classe/interface como camada de acesso a dados
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

}

//interface TarefaRepository = Declaração da interface
//extends JpaRepository<Contato, Long>	= Herda métodos prontos para CRUD
//Tarefa =	Entidade que será gerenciada
//Long = Tipo da chave primária da entidade


//Um repository é a camada de acesso a dados, responsável por falar com o banco, mantendo sua aplicação organizada e limpa.
//Ele permite que você faça operações no banco sem precisar escrever SQL manualmente.