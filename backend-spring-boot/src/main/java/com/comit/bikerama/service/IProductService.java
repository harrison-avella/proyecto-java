package com.comit.bikerama.service;

import java.util.List;

import com.comit.bikerama.domain.Product;

public interface IProductService {
    List<Product> findAll();

    Product findById(Long id);

    List<Product> findByName(String name);

    List<Product> findByCategory(String category);

    Product save(Product product);

    Product update(Product product);

    //TODO: Revicar esta implementação
    void delete(Product product);

}
