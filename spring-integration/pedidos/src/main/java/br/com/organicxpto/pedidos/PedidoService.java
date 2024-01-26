package br.com.organicxpto.pedidos;


import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {



	private final PedidoRepository pedidoRepository;

	private final EstoquePedidoGateway estoquePedidoGateway;

	public PedidoService(PedidoRepository pedidoRepository, EstoquePedidoGateway estoquePedidoGateway) {
		this.pedidoRepository = pedidoRepository;
		this.estoquePedidoGateway = estoquePedidoGateway;
	}

	@Transactional
	public void save(Pedido pedido) {
			pedido.getItens().forEach(i -> this.estoquePedidoGateway.removerEstoque(MessageBuilder.withPayload(new RemoverEstoqueRequest(i.getIdProduct(), i.getQuantidade())).build()));
			this.pedidoRepository.save(pedido);
	}


	public List<Pedido> getAll() {
		return this.pedidoRepository.findAll();
	}
}
