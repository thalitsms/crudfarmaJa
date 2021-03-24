package com.farmaja.FarmaJa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.farmaja.FarmaJa.model.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos /*tipo de entidade*/, Long /*qual tipo de id */> 
{
	public List<Produtos> findAllByTituloContainingIgnoreCase (String titulo);
}
