package com.comit.bikerama.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.comit.bikerama.entity.Product;
import com.comit.bikerama.repository.ProductRepository;
import com.comit.bikerama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        List<Product> productsList = productRepository.findAll();
        return productsList;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return productRepository.existsById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    /*
    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
    */


    /*
     * @Override public List<Product> findByCategory(String category) { return
     * productRepository.findByCategory(category); }
     */
    /*
     * public Product save(Product product){ return
     * productRepository.saveAllAndFlush(product); }
     */

}
