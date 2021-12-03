package com.compasso.productRest.form;

import com.compasso.productRest.modelo.Produto;

public class ProdutoForm {

	private String descricao;
	private String nome;
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
	
	
}
