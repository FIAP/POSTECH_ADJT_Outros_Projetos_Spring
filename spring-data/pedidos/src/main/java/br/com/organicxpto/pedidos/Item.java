package br.com.organicxpto.pedidos;

import java.math.BigDecimal;

public class Item {

	private Long idProduct;

	private BigDecimal quantidade;

	public Item() {
		super();
	}

	public Item(Long idProduct, BigDecimal quantidade) {
		this.idProduct = idProduct;
		this.quantidade = quantidade;
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}
}
