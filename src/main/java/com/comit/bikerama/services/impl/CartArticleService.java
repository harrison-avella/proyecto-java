package com.comit.bikerama.services.impl;

import java.math.BigDecimal;
import java.util.List;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.models.Order;
import com.comit.bikerama.models.Product;
import com.comit.bikerama.models.User;
import com.comit.bikerama.repositories.ICartArticleRepository;
import com.comit.bikerama.repositories.IProductToCartArticleRepository;
import com.comit.bikerama.services.ICartArticleService;

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
        //TODO: repair other method
        BigDecimal totalPrice = new BigDecimal(cartArticle.getProduct().getPrice()).multiply(new BigDecimal(cartArticle.getQuantity()));
    
        // TODO: remplace method by repository
        //totalPrice = totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
        
        cartArticle.setTotalPrice(totalPrice);

        iCartArticleRepository.save(cartArticle);

        return cartArticle;
    }


    @Override
    public CartArticle addProductToCartArticle(Product product, User user, int quantity) {
        // TODO Auto-generated method stub
        List<CartArticle> cartArticleList = findByCart(user.getCart());
    for(CartArticle cartArticle: cartArticleList){
        if(cartArticle.getProduct().getId().equals(product.getId())){
            cartArticle.setQuantity(cartArticle.getQuantity() + quantity);
            cartArticle.setTotalPrice(new BigDecimal(product.getPrice()).multiply(new BigDecimal(quantity)));
            iCartArticleRepository.save(cartArticle);
        }
        // TODO complete method tomorrow
        return null;
    }

    @Override
    public void deleteCartArticle(CartArticle cartArticle) {
        // TODO Auto-generated method stub

    }


    @Override
    public CartArticle save(CartArticle cartArticle) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CartArticle> findByOrder(Order order) {
        // TODO Auto-generated method stub
        return null;
    }

}
