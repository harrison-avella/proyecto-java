package com.comit.bikerama.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.CartArticle;
import com.comit.bikerama.repository.ICartRepository;
import com.comit.bikerama.service.ICartArticleService;
import com.comit.bikerama.service.ICartService;

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
