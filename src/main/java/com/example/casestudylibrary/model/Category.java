package com.example.casestudylibrary.model;

import com.example.casestudylibrary.model.dto.res.CategoryResDto;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public CategoryResDto toCategoryResDto() {
        return new CategoryResDto(id, name);
    }
}
