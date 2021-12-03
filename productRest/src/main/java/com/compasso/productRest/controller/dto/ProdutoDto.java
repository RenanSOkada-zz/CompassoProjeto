package com.compasso.productRest.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.compasso.productRest.modelo.Produto;

public class ProdutoDto {

	private Long id;
	private String descricao;
	private String nome;
	private double preco;

	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
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

	public static List<ProdutoDto> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
	}

}
