package com.comit.bikerama.service;

import com.comit.bikerama.model.Product;
import com.comit.bikerama.repository.IProductRepository;
import com.comit.bikerama.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IService<Product,Long>{


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
        return null;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    /*public Product save(Product product){
        return productRepository.saveAllAndFlush(product);
    }*/

}
