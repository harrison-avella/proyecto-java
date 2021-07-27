package com.comit.bikerama.service;

import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.domain.Order;
import com.comit.bikerama.domain.Product;
import com.comit.bikerama.domain.User;

public interface CartArticleService {
    List<CartArticle> findByCart(Cart cart);

    CartArticle findById(Long id);

    CartArticle updateCartArticle(CartArticle cartArticle);

    // void deleteCartArticle(CartArticle cartArticle);

    CartArticle addProductToCartArticle(Product product, User user, int quantity);

    CartArticle save(CartArticle cartArticle);

    List<CartArticle> findByOrder(Order order);
}
