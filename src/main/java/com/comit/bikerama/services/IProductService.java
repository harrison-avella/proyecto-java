package com.comit.bikerama.services;

import java.util.List;

import com.comit.bikerama.models.Product;

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
