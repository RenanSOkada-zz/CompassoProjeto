package com.compasso.productRest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.productRest.controller.dto.ProdutoDto;
import com.compasso.productRest.form.ProdutoForm;
import com.compasso.productRest.modelo.Produto;
import com.compasso.productRest.repository.ProdutoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
@Api(value="API REST Controller Produtos")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@ApiOperation(value="Retorna uma lista de Produtos ou o nome de um produto especifico")
	@GetMapping
	public List<ProdutoDto> lista(String nome) {

		if (nome == null) {
			List<Produto> produtos = produtoRepository.findAll();
			return ProdutoDto.converter(produtos);

		} else {

			List<Produto> produtos = produtoRepository.findByNome(nome);
			return ProdutoDto.converter(produtos);
		}

	}
	
	@ApiOperation(value="Retorna um filtro search personalizado")
	@GetMapping("/search")
	public List<ProdutoDto> procurar(@RequestParam String q, @RequestParam  double minPricedb,
			@RequestParam  double maxPricedb) {
		List<Produto> produtos = produtoRepository.findUsingFilters(q, minPricedb, maxPricedb);

		for (Produto produto : produtos) {
			boolean comparador = compararPrecos(minPricedb, maxPricedb, produto);
			if (comparador) {
				return ProdutoDto.converter(produtos);
			}
		}
		return null;
	}

	@ApiOperation(value="Salva um produto")
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter();
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	@ApiOperation(value="Retorna um produto unico")
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new ProdutoDto(optional.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@ApiOperation(value="Atualiza um produto")
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {

		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			Produto produto = form.atualizar(id, produtoRepository);
			return ResponseEntity.ok(new ProdutoDto(produto));
		}
		return ResponseEntity.notFound().build();
	}

//	@ApiOperation(value="Deleta um produto")
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> excluir(@PathVariable Long id) {

		Optional<Produto> optional = produtoRepository.findById(id);
		if (optional.isPresent()) {
			produtoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

	
	private boolean compararPrecos(double minPricedb, double maxPricedb, Produto produto) {
		boolean b = produto.getPreco() >= minPricedb && produto.getPreco() <= maxPricedb;
		return b;
	}
}