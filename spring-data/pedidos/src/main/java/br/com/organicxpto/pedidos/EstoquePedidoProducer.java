package br.com.organicxpto.pedidos;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "estoque", url = "http://localhost:8081/api")
public interface EstoquePedidoProducer {

	@PostMapping(value = "/consumer-remova-estoque")
	void removerEstoque(RemoverEstoqueRequest removerEstoqueRequest);
}
