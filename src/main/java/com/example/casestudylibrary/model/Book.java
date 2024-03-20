package com.example.casestudylibrary.model;

import com.example.casestudylibrary.model.dto.req.BookReqDto;
import com.example.casestudylibrary.model.dto.res.BookResDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToOne
    private Image image;
    private String status;
    private String publisher;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public BookResDto toBookResDto() {
        return new BookResDto(id, name, description, publisher, status, category);
    }


}
