package com.comit.bikerama.services;

import java.util.List;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.models.Order;
import com.comit.bikerama.models.Product;
import com.comit.bikerama.models.User;

public interface ICartArticleService {
    List<CartArticle> findByCart(Cart cart);

    CartArticle findById(Long id);

    CartArticle updateCartArticle(CartArticle cartArticle);

    void deleteCartArticle(CartArticle cartArticle);

    CartArticle addProductToCartArticle(Product product, User user, int quantity);

    CartArticle save(CartArticle cartArticle);

    List<CartArticle> findByOrder(Order order);
}
