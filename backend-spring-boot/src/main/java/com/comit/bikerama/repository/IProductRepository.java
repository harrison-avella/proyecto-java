package com.comit.bikerama.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.comit.bikerama.domain.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findByName(String Name);

}
