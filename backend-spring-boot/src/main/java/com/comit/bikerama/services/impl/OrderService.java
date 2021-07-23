package com.comit.bikerama.services.impl;

import java.util.Calendar;
import java.util.List;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.Order;
import com.comit.bikerama.models.Product;
import com.comit.bikerama.models.User;
import com.comit.bikerama.repositories.IOrderRepository;
import com.comit.bikerama.models.CartArticle;
import com.comit.bikerama.services.ICartArticleService;
import com.comit.bikerama.services.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository iOrderRepository;

    @Autowired
    private ICartArticleService iCartArticleService;

    public Order createOrder(Cart cart, User user) {
        Order order = new Order();
        order.setStatus("Init");
        order.setShippingAddress(user.getAddress());
        // TODO: implement method payment
        // order.setPayment(payment);

        List<CartArticle> cartArticleList = iCartArticleService.findByCart(cart);

        for (CartArticle cartArticle : cartArticleList) {
            Product product = cartArticle.getProduct();
            cartArticle.setOrder(order);
            product.setStock(product.getStock() - cartArticle.getQuantity());
        }
        order.setCartArticleList(cartArticleList);
        // use ulti.date
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setTotalPayable(cart.getTotalPayable());
        order.setUser(user);

        order = iOrderRepository.save(order);
        return order;
    }

    public Order findById(Long id) {
        return iOrderRepository.getById(id);
    }
}
//fecht type, entidad y lista asociada, curso y alumnos
// fetctyupe eager cuando pide el curso trae alumnos
//lazy especificar cuando la consulta que traiga los alumnos y se logra con joing.