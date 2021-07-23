package com.comit.bikerama.repositories;

import java.util.List;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartArticleRepository extends JpaRepository<CartArticle, Long> {
    List<CartArticle> findByCart(Cart cart);

    List<CartArticle> findByOrder(Order order);
}
