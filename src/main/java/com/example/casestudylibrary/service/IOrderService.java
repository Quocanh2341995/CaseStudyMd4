package com.example.casestudylibrary.service;

import com.example.casestudylibrary.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAll();
    Order findOne(Long id);
    void save(Order order);
    void delete(Long id);
    void update(Order order);
}
