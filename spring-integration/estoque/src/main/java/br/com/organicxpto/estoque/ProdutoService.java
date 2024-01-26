package br.com.organicxpto.estoque;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void removerEstoque(Long id, BigDecimal quantidade) {
		Produto produtoLocalizado = this.produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não localizado"));
		produtoLocalizado.setQuantidade(getFinalEstoqueQuantidade(produtoLocalizado.getQuantidade(), quantidade));
		this.produtoRepository.save(produtoLocalizado);
	}

	public List<Produto> getAll() {
		return this.produtoRepository.findAll();
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
