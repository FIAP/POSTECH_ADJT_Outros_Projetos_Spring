package br.com.organicxpto.pedidos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class EstoquePedidoConfiguration {

	@Bean
	public MessageChannel estoque() {
		DirectChannel directChannel = new DirectChannel();
		directChannel.setFailover(false);
		return directChannel;
	}

	@Bean
	public IntegrationFlow estoqueFlow() {
		return IntegrationFlow.from("estoque")
				.handle(
						Http.outboundGateway("http://localhost:8081/api/remova-estoque")
								.httpMethod(HttpMethod.POST))
				.log().bridge()
				.get();
	}
}
