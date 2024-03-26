package com.example.casestudylibrary.domain.dto.res;

import com.example.casestudylibrary.domain.Category;
import com.example.casestudylibrary.domain.File;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResDto {

    private Long id;
    private String name;
    private String description;
    private FileResDto urlPoster;
    private String publisher;
    private String status;
    private CategoryResDto category;

//    public BookResDto (Long id, String name, String description,File poster, String publisher, String status, Category category) {
//        this.id = id;
//        this.name = name;
//        this.description = description;
//        this.poster = poster;
//        this.publisher = publisher;
//        this.status = status;
//        this.categoryName = category.getName();
//        this.category = category.toCategoryResDto();
//    }




}
