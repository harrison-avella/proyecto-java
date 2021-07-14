package com.comit.bikerama.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import com.comit.bikerama.models.Product;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Long> {

}
