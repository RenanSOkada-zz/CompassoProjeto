package com.compasso.productRest.form;

import com.compasso.productRest.modelo.Produto;
import com.compasso.productRest.repository.ProdutoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProdutoForm {

	@NotNull
	@NotEmpty
	@Length(min = 1)
	private String descricao;

	@NotNull
	@NotEmpty
	@Length(min = 1)
	private String nome;

	@NotNull
	private double preco;

	public String getDescricao() {
		return descricao;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
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
		builder.append("ProdutoForm [descricao=");
		builder.append(descricao);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", preco=");
		builder.append(preco);
		builder.append("]");
		return builder.toString();
	}

	public Produto converter() {
		return new Produto(descricao, nome, preco);
	}

	public Produto atualizar(Long id, ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getById(id);
		
		produto.setDescricao(this.descricao);
		produto.setNome(this.nome);
		produto.setPreco(this.preco);
		
		return produto;
	}

}
