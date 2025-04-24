package com.ecommerce.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    //buscar categoria
    List<Produto> findByCategoria(String categoria);
}
