package com.comit.bikerama.service;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Product;

public interface IProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);
    
    Product save(Product product);

    Product update(Product product);

    // TODO: Revicar esta implementação
    void delete(Product product);

    List<Product> findByName(String name);

    List<Product> findByCategory(String category);

}
