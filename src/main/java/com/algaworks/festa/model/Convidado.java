package com.algaworks.festa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Convidado implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private Integer quantidade_acompanhantes;

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

	public Integer getQuantidade_acompanhantes() {
		return quantidade_acompanhantes;
	}

	public void setQuantidade_acompanhantes(Integer quantidade_acompanhantes) {
		this.quantidade_acompanhantes = quantidade_acompanhantes;
	}
	

}
