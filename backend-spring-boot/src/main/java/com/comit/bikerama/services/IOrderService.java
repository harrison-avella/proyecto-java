package com.comit.bikerama.services;

import com.comit.bikerama.models.Cart;
import com.comit.bikerama.models.Order;
import com.comit.bikerama.models.User;

public interface IOrderService {
    // TODO: createOrder method
    Order createOrder(Cart cart, User user);

    Order findById(Long id);
}
