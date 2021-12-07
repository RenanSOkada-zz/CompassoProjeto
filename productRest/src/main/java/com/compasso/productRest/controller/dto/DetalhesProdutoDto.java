package com.compasso.productRest.controller.dto;

import com.compasso.productRest.modelo.Produto;

public class DetalhesProdutoDto {

	private Long id;
	private String descricao;
	private String nome;
	private double preco;
	private String nomeUsuario;

	public DetalhesProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.nomeUsuario = produto.getAutor().getNome();
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

	public String getNomeUsuario() {
		return nomeUsuario;
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

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

}
