package com.compasso.productRest.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compasso.productRest.controller.dto.DetalhesProdutoDto;
import com.compasso.productRest.controller.dto.ProdutoDto;
import com.compasso.productRest.controller.form.AtualizacaoProdutoForm;
import com.compasso.productRest.form.ProdutoForm;
import com.compasso.productRest.modelo.Produto;
import com.compasso.productRest.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutoRepository produtoRepository;

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

	@PostMapping
	public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
		Produto produto = form.converter();
		produtoRepository.save(produto);

		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}

	@GetMapping("/{id}")
	public ProdutoDto detalhar(@PathVariable Long id) {
		Produto produto = produtoRepository.getById(id);
		return new ProdutoDto(produto);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutoDto> atualizat(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {
		Produto produto = form.atualizar(id, produtoRepository);

		return ResponseEntity.ok(new ProdutoDto(produto));

	}

}
