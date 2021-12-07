package com.compasso.productRest.form;

import com.compasso.productRest.modelo.Produto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ProdutoForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String descricao;

	@NotNull
	@NotEmpty
	@Length(min = 5)
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

}
