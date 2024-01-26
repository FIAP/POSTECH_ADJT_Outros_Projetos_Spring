package br.com.organicxpto.estoque;

import java.util.function.Consumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EstoqueConsumer {

	private final ProdutoService produtoService;

	public EstoqueConsumer(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@Bean(name = "remova-estoque")
	Consumer<ProdutoRequested> consumer(){
		return produtoRequested -> this.produtoService.removerEstoque(produtoRequested.getIdProduto(), produtoRequested.getQuantidade());
	}
}
