package com.example.orderservice.service;

import com.example.orderservice.dto.OrderDTO;
import com.example.orderservice.jpa.OrderEntity;
import com.example.orderservice.jpa.OrderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private Environment env;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, Environment env) {
        this.env = env;
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(UUID.randomUUID().toString());
        orderDTO.setTotalPrice( orderDTO.getUnitPrice() * orderDTO.getQty() );

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        OrderEntity orderEntity = mapper.map(orderDTO, OrderEntity.class);

        orderRepository.save(orderEntity);

        return null;
    }

    @Override
    public OrderDTO getOrderByOderId(String orderId) {

        OrderEntity order = orderRepository.findByOrderId(orderId);

        OrderDTO orderDTO = new ModelMapper().map(order, OrderDTO.class);

        return orderDTO;
    }

    @Override
    public Iterable<OrderEntity> getOrdersByUserId(String userId) {

        Iterable<OrderEntity> resultList = orderRepository.findByUserId(userId);

        return resultList;
    }
}
