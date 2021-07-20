package com.comit.bikerama.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.repositories.ICartRepository;
import com.comit.bikerama.services.ICartArticleService;
import com.comit.bikerama.services.ICartService;

import org.springframework.beans.factory.annotation.Autowired;

public class CartService implements ICartService {
    
    @Autowired
    private ICartArticleService iCartArticleService;

    @Autowired
    private ICartRepository iCartRepository;

    @Override
    public Cart updateCart(Cart cart) {
        BigDecimal total = new BigDecimal(0);

        List<CartArticle> cartArticleList = iCartArticleService.findByCart(cart);
        for (CartArticle cartArticle : cartArticleList) {
            if(cartArticle.getProduct().getStock() > 0){
                iCartArticleService.updateCartArticle(cartArticle);
                total = total.add(cartArticle.getTotalPrice());
            }
        }
        cart.setTotalPayable(total);
        iCartRepository.save(cart);
        
        return cart;
    }
    
}
