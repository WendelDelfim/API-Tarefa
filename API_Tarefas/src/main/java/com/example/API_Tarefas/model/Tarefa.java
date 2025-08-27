package com.example.API_Tarefas.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Criando uma entidade em Tarefa. 
@Entity                                                                    			//@Entity faz com que a Classe Tarefa se torne uma tabela no banco de dados.
@Table (name = "Tarefa")                                                  			//@Table define o nome da tabela
public class Tarefa {
																					//É uma anotacao JPA. Marca esse atributo como chave primaria da entidade. 
//Criando atributos dentro de nossa classe.								 			//O banco vai usar esse campo para identificar unicamente cada registo da tabela.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)								//Identity sera gerado pelo banco de dados automaticamente.
	private Long id;
	
	private String nome;
	private String dataEntrega;
	private String responsavel;
	
	
	//Getters e Setters 															//Getters(pega) e Setters(muda) sao feitos para conseguir colocar regras/modificacoes.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	
	@Override																		//estou trocando a versão da superclasse por uma versão personalizada na subclasse.
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", dataEntrega=" + dataEntrega + ", responsavel=" + responsavel + "]";
	}
	@Override
	public int hashCode() {															//Gera número para identificar o objeto rapidamente
		return Objects.hash(dataEntrega, id, nome, responsavel);
	}
	@Override
	public boolean equals(Object obj) {												//Define quando dois objetos são considerados iguais
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(dataEntrega, other.dataEntrega) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
	}
	
	
	

}
