package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
