package br.com.organicxpto.estoque;

import java.math.BigDecimal;

public class Produto {

	private Long id;

	private String nome;

	private BigDecimal quantidade;

	public Produto(Long id, String nome, BigDecimal quantidade) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}
}
