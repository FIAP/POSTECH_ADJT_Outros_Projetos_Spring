package br.com.organicxpto.pedidos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository  extends JpaRepository<Pedido, UUID> {
}
