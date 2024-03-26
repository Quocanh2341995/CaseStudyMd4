package com.example.casestudylibrary.domain;

import com.example.casestudylibrary.domain.dto.res.BookResDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

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
    private File poster;

    private String status;
    private String publisher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @Where(clause = "deleted <> 'DELETED'")
    private Category category;

    public BookResDto toBookResDto() {
                    /*
            private Long id;
            private String name;
            private String description;
            private File poster;
            private String publisher;
            private String status;
            private String categoryName;
            private CategoryResDto category;
             */
        return new BookResDto(id, name, description,poster.toFileResDto(), publisher, status, category.toCategoryResDto());
    }

}
