package br.com.organicxpto.estoque;

import java.math.BigDecimal;

public class ProdutoRequested {

	private Long idProduto;

	private BigDecimal quantidade;

	public ProdutoRequested() {
		super();
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
}
