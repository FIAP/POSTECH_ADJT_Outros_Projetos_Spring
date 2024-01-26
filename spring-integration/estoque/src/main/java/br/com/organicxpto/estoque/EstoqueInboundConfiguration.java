package br.com.organicxpto.estoque;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.http.dsl.Http;
import org.springframework.messaging.MessageChannel;

@Configuration
public class EstoqueInboundConfiguration {

	@Bean
	public MessageChannel removerEstoque() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow inbound() {
		return IntegrationFlow.from(
						Http.inboundGateway("/api/remova-estoque")
								.requestMapping(m -> m.methods(HttpMethod.POST))
								.statusCodeFunction(m -> HttpStatus.NO_CONTENT))
				.channel("removerEstoque")
				.get();

	}
}
