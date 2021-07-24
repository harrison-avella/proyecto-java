package com.comit.bikerama.service.impl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.domain.Order;
import com.comit.bikerama.domain.Product;
import com.comit.bikerama.domain.ProductToCartArticle;
import com.comit.bikerama.domain.User;
import com.comit.bikerama.repository.ICartArticleRepository;
import com.comit.bikerama.repository.IProductToCartArticleRepository;
import com.comit.bikerama.service.ICartArticleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartArticleService implements ICartArticleService {

    @Autowired
    private ICartArticleRepository iCartArticleRepository;

    @Autowired
    private IProductToCartArticleRepository iProductToCartArticleRepository;

    @Override
    public List<CartArticle> findByCart(Cart cart) {
        return iCartArticleRepository.findByCart(cart);
    }

    @Override
    public CartArticle findById(Long id) {
        return iCartArticleRepository.findById(id).get();
    }

    @Override
    public CartArticle updateCartArticle(CartArticle cartArticle) {
        BigDecimal totalPrice = cartArticle.getProduct().getPrice().multiply(new BigDecimal(cartArticle.getQuantity()));
        // totalPrice = totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        totalPrice = totalPrice.round(new MathContext(2, RoundingMode.HALF_UP));

        cartArticle.setTotalPrice(totalPrice);

        iCartArticleRepository.save(cartArticle);

        return cartArticle;
    }

    @Override
    public CartArticle addProductToCartArticle(Product product, User user, int quantity) {
        // TODO Auto-generated method stub
        List<CartArticle> cartArticleList = findByCart(user.getCart());
        for (CartArticle cartArticle : cartArticleList) {
            if (cartArticle.getProduct().getId().equals(product.getId())) {
                cartArticle.setQuantity(cartArticle.getQuantity() + quantity);
                cartArticle.setTotalPrice(product.getPrice().multiply(new BigDecimal(quantity)));
                iCartArticleRepository.save(cartArticle);
                return cartArticle;
            }
        }
        CartArticle cartArticle = new CartArticle();
        cartArticle.setCart(user.getCart());
        cartArticle.setProduct(product);

        cartArticle.setQuantity(quantity);
        cartArticle.setTotalPrice(product.getPrice().multiply(new BigDecimal(quantity)));
        cartArticle = iCartArticleRepository.save(cartArticle);

        ProductToCartArticle productToCartArticle = new ProductToCartArticle();
        productToCartArticle.setProduct(product);
        productToCartArticle.setCartArticle(cartArticle);
        iProductToCartArticleRepository.save(productToCartArticle);
        return cartArticle;
    }


/*
    @Override
    public void deleteCartArticle(CartArticle cartArticle) {
        iCartArticleRepository.delete(cartArticle);
        iProductToCartArticleRepository.delete(cartArticle);

    }

    */
    @Override
    public CartArticle save(CartArticle cartArticle) {
        return iCartArticleRepository.save(cartArticle);
    }

    @Override
    public List<CartArticle> findByOrder(Order order) {
        return iCartArticleRepository.findByOrder(order);
    }

}
