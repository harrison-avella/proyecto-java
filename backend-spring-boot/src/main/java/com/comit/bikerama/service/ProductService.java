package com.comit.bikerama.service;

import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Product;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);
    
    Product save(Product product);

    Product update(Product product);

    // TODO: Revicar esta implementação
    String delete(Long id);

    List<Product> findByName(String name);

   // List<Product> findByCategory(String category);

}
