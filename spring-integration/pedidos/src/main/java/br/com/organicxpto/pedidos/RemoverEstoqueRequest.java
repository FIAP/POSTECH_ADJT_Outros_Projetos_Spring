package br.com.organicxpto.pedidos;

import java.math.BigDecimal;

public class RemoverEstoqueRequest {

	private Long idProduto;

	private BigDecimal quantidade;

	public RemoverEstoqueRequest(Long idProduto, BigDecimal quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
}
