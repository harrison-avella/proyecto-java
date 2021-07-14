package com.comit.bikerama.services.impl;

import com.comit.bikerama.models.Product;
import com.comit.bikerama.repositories.IProductRepository;
import com.comit.bikerama.services.impl.IService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProducService{


    private final IProductRepository iproductRepository;

    @Autowired
    public ProductService(IProductRepository iProductRepository){
        this.iproductRepository = iProductRepository;
    }

    @Override
    public List<Product> getAll() {
        return iproductRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return iproductRepository.findById(id).get();
    }
    

    @Override
    public Product save(Product product) {
        return iproductRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return iproductRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        iproductRepository.delete(id);
    }

    /*public Product save(Product product){
        return productRepository.saveAllAndFlush(product);
    }*/

}
