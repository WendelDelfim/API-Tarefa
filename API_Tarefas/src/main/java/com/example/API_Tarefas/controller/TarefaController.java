package com.example.API_Tarefas.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_Tarefas.model.Tarefa;
import com.example.API_Tarefas.repository.TarefaRepository;

@RestController 																	//Responde a requisicoes web e retornam em json, e nao uma pagina HTML
@RequestMapping({"/Tarefa"})														//Define o caminho base da URL
public class TarefaController {
	private TarefaRepository repository;											//Aqui, a controller vai usar o repository para buscar, salvar, atualizar ou deletar contatos.
	
	TarefaController (TarefaRepository tarefaRepository){ 							//Esse é o construtor da controller.
		this.repository = tarefaRepository;
	}
	
	// =======================
    // LISTAR TODOS OS CONTATOS
    // =======================	
	@GetMapping																		//endpoint HTTP GET - Responde a requisições GET feitas para o caminho base do controller - Retorna uma lista com todos os registros de uma entidade, no caso, Tarefa
	public List<?> findAll() {
		return repository.findAll(); //// retorna todos os contatos como JSON
	}
	
	
	// =======================
    // BUSCAR CONTATO POR ID
    // =======================
	@GetMapping(path = { "/{id}" })
	public ResponseEntity<?> findById(@PathVariable long id) {
		return repository.findById(id)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	// =======================
    // CRIAR NOVO CONTATO
    // =======================
	@PostMapping																	//Responde a requisições HTTP POST. - Usa o repository.save(contato) para salvar esse contato no banco de dados. - Retorna o objeto salvo (já com o ID preenchido)
	public Tarefa create(@RequestBody Tarefa tarefa) {
		return repository.save(tarefa); // salva o contato no banco
	}
	

    // =======================
    // ATUALIZAR CONTATO EXISTENTE
    // =======================
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa) {
		return repository.findById(id).map(record -> {
			record.setNome(tarefa.getNome());
			record.setDataEntrega(tarefa.getDataEntrega());
			record.setResponsavel(tarefa.getResponsavel());
			Tarefa updated = repository.save(record);
			return ResponseEntity.ok().body(updated);
		})
		.orElse(ResponseEntity.notFound().build());
	}
	
	
	// =======================
	// DELETAR CONTATO
	// =======================
	@DeleteMapping(path = { "/{id}" })												//Ele responde a requisições DELETE /entidade/{id}
	public ResponseEntity<?> delete(@PathVariable long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		})
		.orElse(ResponseEntity.notFound().build());
	}
}





