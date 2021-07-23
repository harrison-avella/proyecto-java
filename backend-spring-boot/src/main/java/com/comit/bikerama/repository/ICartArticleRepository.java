package com.comit.bikerama.repository;

import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartArticleRepository extends JpaRepository<CartArticle, Long> {
    List<CartArticle> findByCart(Cart cart);

    List<CartArticle> findByOrder(Order order);
}
