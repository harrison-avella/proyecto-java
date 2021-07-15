package com.comit.bikerama.services;

import com.comit.bikerama.models.Order;

public interface IOrderService {
    // TODO: createOrder method
    Order createOrder(Order order);

    Order findById(Long id);
}
