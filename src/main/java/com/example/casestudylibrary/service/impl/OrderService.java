package com.example.casestudylibrary.service.impl;


import com.example.casestudylibrary.domain.Order;
import com.example.casestudylibrary.domain.dto.req.OrderReqDto;
import com.example.casestudylibrary.domain.dto.req.StatusOrderReqDto;
import com.example.casestudylibrary.domain.dto.res.OrderResDto;
import com.example.casestudylibrary.domain.enumration.EStatus;
import com.example.casestudylibrary.repository.IOrderRepository;
import com.example.casestudylibrary.repository.IUserRepository;
import com.example.casestudylibrary.service.IOrderService;
import com.example.casestudylibrary.service.book.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final IUserRepository userRepository;
    private final IOrderRepository orderRepository;
    private final IBookService bookService;
    @Override
    public List<OrderResDto> findAll() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResDto> orderResDtos = new ArrayList<>();
        for (Order order : orders) {
            orderResDtos.add(order.toOrderResDto());
        }
        return orderResDtos;
    }


    @Override
    public OrderResDto findOrdeById(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            return order.toOrderResDto();
        }
        return null;

    }


    @Override
    public void save(OrderReqDto orderReqDto) {
        Order order = new Order();
        order.setBorrowDate(LocalDate.parse(orderReqDto.getBorrowDate()));
        order.setPayDate(LocalDate.parse(orderReqDto.getPayDate()));
        order.setBook(bookService.findBookById(orderReqDto.getBookId()));
        order.setEStatus(EStatus.valueOf(orderReqDto.getStatus()));
        order.setUser(userRepository.findById(orderReqDto.getUserId()).orElse(null));
        orderRepository.save(order); }



    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public void updateStatusOrderById(Long id, StatusOrderReqDto statusOrderReqDto) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return;
        }
        order.setEStatus(EStatus.valueOf(statusOrderReqDto.getStatus()));
        orderRepository.save(order);
    }


}

