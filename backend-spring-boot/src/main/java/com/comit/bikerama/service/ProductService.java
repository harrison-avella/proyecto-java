package com.comit.bikerama.service;

import java.util.List;
import java.util.Optional;
import com.comit.bikerama.entity.Product;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByName(String name);

    void save(Product product);

    void delete(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);

    //Product update(Product product);

    // List<Product> findByCategory(String category);

}
