package com.example.casestudylibrary.service.impl;

import com.example.casestudylibrary.model.Order;
import com.example.casestudylibrary.repository.IOrderRepository;
import com.example.casestudylibrary.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;
    @Override
    public List<Order> findAll() { return orderRepository.findAll(); }



    @Override
    public Order findOne(Long id) { return orderRepository.findById(id).orElse(null); }



    @Override
    public void save(Order order) { orderRepository.save(order); }



    @Override
    public void delete(Long id) { orderRepository.deleteById(id);

    }
    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }
}
