package com.example.casestudylibrary.domain;

import com.example.casestudylibrary.domain.dto.res.OrderResDto;
import com.example.casestudylibrary.domain.enumration.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

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
    private Book book;
    private EStatus eStatus;


    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    public OrderResDto toOrderResDto() {
        return new OrderResDto(
                this.id,
                this.borrowDate,
                this.payDate,
                null,
                this.eStatus
        );
    }
}
