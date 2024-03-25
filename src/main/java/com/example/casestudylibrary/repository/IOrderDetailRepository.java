package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetails, Long> {
}
