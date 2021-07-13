package com.comit.bikerama.service;

import com.comit.bikerama.model.Product;
import com.comit.bikerama.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    /*public Product save(Product product){
        return productRepository.saveAllAndFlush(product);
    }*/

}
