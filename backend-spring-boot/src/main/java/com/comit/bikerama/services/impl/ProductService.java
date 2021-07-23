package com.comit.bikerama.services.impl;

import com.comit.bikerama.models.Product;
import com.comit.bikerama.repositories.IProductRepository;
import com.comit.bikerama.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{


    private final IProductRepository iProductRepository;

    @Autowired
    public ProductService(IProductRepository iProductRepository){
        this.iProductRepository = iProductRepository;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productsList = iProductRepository.findAll();
        List<Product> activeProductList = new ArrayList<>();
        
        for(Product product : productsList){
            if(product.isActive()){
                activeProductList.add(product);
            }
        }
        return activeProductList;
    }

    @Override
    public Product findById(Long id) {
        return iProductRepository.findById(id).get();
    }
    

    @Override
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return iProductRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        iProductRepository.delete(product);
    //TODO: Revisar este metodo
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return iProductRepository.findByCategory(category);
    }

    /*public Product save(Product product){
        return productRepository.saveAllAndFlush(product);
    }*/

}
