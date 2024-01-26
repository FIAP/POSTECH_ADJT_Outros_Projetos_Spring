package br.com.organicxpto.estoque;

import java.math.BigDecimal;
import java.util.List;

import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class ProductSeeder {

	private final ProdutoRepository produtoRepository;

	public ProductSeeder(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	@PostConstruct
	public void loadDbIfEmpty() {
		List<Produto> all = this.produtoRepository.findAll();
		if (all.isEmpty()) {
			this.produtoRepository.saveAll(
					List.of(
							new Produto(1L, "Tangerina", BigDecimal.valueOf(10000L)),
							new Produto(2l, "Manga", BigDecimal.valueOf(10000))));
		}
	}
}
