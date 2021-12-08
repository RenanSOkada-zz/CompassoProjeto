package com.compasso.productRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.compasso.productRest.modelo.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	List<Produto> findByNome(String nome);

	@Query(value = "SELECT * FROM produto WHERE " + "(:q IS NULL OR (UPPER(produto.nome)"
			+ " LIKE UPPER(CONCAT('%', :q, '%'))" + "OR UPPER(produto.descricao) "
			+ "LIKE UPPER(CONCAT('%', :q, '%'))))" + "AND (:maxPricedb IS NULL OR preco <= :maxPricedb)"
			+ "AND (:minPricedb IS NULL OR preco >= :minPricedb)", nativeQuery = true)
	List<Produto> findUsingFilters(@Param("q") String q, @Param("minPricedb") Double minPricedb,@Param("maxPricedb") Double maxPricedb);

}
