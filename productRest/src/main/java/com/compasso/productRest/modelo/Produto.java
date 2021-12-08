package com.compasso.productRest.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private String nome;
	private double preco;

	public Produto() {
	}

	public Produto(String descricao, String nome, double preco) {
		this.descricao = descricao;
		this.nome = nome;
		this.preco = preco;
	}


	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Produto [id=");
		builder.append(id);
		builder.append(", descricao=");
		builder.append(descricao);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", preco=");
		builder.append(preco);
		builder.append("]");
		return builder.toString();
	}

}
