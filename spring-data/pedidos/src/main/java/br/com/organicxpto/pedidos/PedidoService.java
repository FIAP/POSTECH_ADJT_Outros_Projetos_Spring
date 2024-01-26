package br.com.organicxpto.pedidos;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PedidoService {

	private final EstoquePedidoProducer estoquePedidoProducer;

	private List<Pedido> fakeDd = new ArrayList<>();

	public PedidoService(EstoquePedidoProducer estoquePedidoProducer) {
		this.estoquePedidoProducer = estoquePedidoProducer;
	}

	public void save(Pedido pedido) {
//		try {
			pedido.getItens().forEach(i -> this.estoquePedidoProducer.removerEstoque(new RemoverEstoqueRequest(i.getIdProduct(), i.getQuantidade())));
			this.fakeDd.add(pedido);
//		} catch (Exception e){
//			throw new RuntimeException("Fora de estoque");
//		}
	}

	public List<Pedido> getAll() {
		return this.fakeDd;
	}
}
