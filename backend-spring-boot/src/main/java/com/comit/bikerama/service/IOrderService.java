package com.comit.bikerama.service;

import com.comit.bikerama.domain.Cart;
import com.comit.bikerama.domain.Order;
import com.comit.bikerama.domain.User;

public interface IOrderService {
    // TODO: createOrder method
    Order createOrder(Cart cart, User user);

    Order findById(Long id);
}
