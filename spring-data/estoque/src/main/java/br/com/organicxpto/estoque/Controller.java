package br.com.organicxpto.estoque;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	private final ProdutoService produtoService;

	public Controller(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("/get-all")
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(this.produtoService.getAll());
	}




}
