package com.compasso.productRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.productRest.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findByNome(String nome);

}
