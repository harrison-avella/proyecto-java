package com.comit.bikerama.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.comit.bikerama.domain.Product;
import com.comit.bikerama.repository.IProductRepository;
import com.comit.bikerama.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService{


    private final IProductRepository productRepository;

    @Autowired
    public ProductService(IProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productsList = productRepository.findAll();
        List<Product> activeProductList = new ArrayList<>();
        
        for(Product product : productsList){
            if(product.isActive()){
                activeProductList.add(product);
            }
        }
        return activeProductList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
    

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    //TODO: Revisar este metodo
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    /*public Product save(Product product){
        return productRepository.saveAllAndFlush(product);
    }*/

}
