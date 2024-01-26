package br.com.organicxpto.estoque;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class EstoqueInboundService {

	private final ProdutoService produtoService;

	public EstoqueInboundService(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@ServiceActivator(inputChannel = "removerEstoque")
	public void removerEstoque(Message<ProdutoRequested> produtoRequestedMessage) {
		this.produtoService.removerEstoque(produtoRequestedMessage.getPayload().getIdProduto(), produtoRequestedMessage.getPayload().getQuantidade());
	}
}
