package br.com.organicxpto.estoque;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	private List<Produto> fakeDb = List.of(
			new Produto(1L, "Tomates", BigDecimal.valueOf(1000000)),
			new Produto(2L, "Abacaxi", BigDecimal.TEN));


	public void removerEstoque(Long id, BigDecimal quantidade) {
		Produto produtoLocalizado = this.fakeDb.stream().filter(
						x -> x.getId().equals(id))
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Produto não localizado"));

		produtoLocalizado.setQuantidade(getFinalEstoqueQuantidade(produtoLocalizado.getQuantidade(), quantidade));
	}

	public List<Produto> getAll() {
		return this.fakeDb;
	}

	private BigDecimal getFinalEstoqueQuantidade(BigDecimal quantiadadeDisponivel, BigDecimal quantidadeSolicitada) {
		final BigDecimal novaQuantidade = quantiadadeDisponivel.subtract(quantidadeSolicitada);
		if (novaQuantidade.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalStateException("Não há estoque suficiente");
		}
		else {
			return novaQuantidade;
		}
	}
}
