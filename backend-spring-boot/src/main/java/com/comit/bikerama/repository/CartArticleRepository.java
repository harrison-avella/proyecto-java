package com.comit.bikerama.repository;

import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.domain.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface CartArticleRepository extends JpaRepository<CartArticle, Long> {
    List<CartArticle> findByCart(Cart cart);

    List<CartArticle> findByOrder(Order order);
}
