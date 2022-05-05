package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.jpa.OrderEntity;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDetails);
    OrderDTO getOrderByOderId(String orderId);
    Iterable<OrderEntity> getOrdersByUserId(String userId);

}
