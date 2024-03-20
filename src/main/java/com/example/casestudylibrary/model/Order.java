package com.example.casestudylibrary.model;

import com.example.casestudylibrary.model.enumperation.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate borrowDate;
    private LocalDate payDate;
    @OneToOne
    private User user;
    @OneToOne
    private Book book;
    private EStatus eStatus;
}
