package br.com.organicxpto.pedidos;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GeradorPedidos {

	private final PedidoService pedidoService;

	public GeradorPedidos(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}

	@Scheduled(fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
	public void crieFakePedido() {
		final List<Item> itens = List.of(new Item(1L, BigDecimal.valueOf(2L)));
		this.pedidoService.save(new Pedido(UUID.randomUUID(), UUID.randomUUID(), itens));
	}

}
