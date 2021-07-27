package com.comit.bikerama.repository;

import java.util.List;

import com.comit.bikerama.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface ProductRepository extends JpaRepository<Product, Long> {

    
    //List<Product> findByCategory(String category);

    List<Product> findByName(String name);

}
