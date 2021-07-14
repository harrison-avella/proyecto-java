package com.comit.bikerama.repositories;

import javax.transaction.Transactional;

import com.comit.bikerama.models.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface IShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    
}
