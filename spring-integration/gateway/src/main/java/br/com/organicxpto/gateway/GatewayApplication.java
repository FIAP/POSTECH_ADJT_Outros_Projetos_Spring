package br.com.organicxpto.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("estoque", r -> r.path("/estoque/**")
						.and()
						.not( p->p.path("/estoque/api/**"))
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8081"))
				.route("pedidos", r -> r.path("/pedidos/**")
						.filters(f -> f.stripPrefix(1))
						.uri("http://localhost:8082"))
				.build();
	}

}
