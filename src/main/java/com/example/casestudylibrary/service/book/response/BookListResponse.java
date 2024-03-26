package com.example.casestudylibrary.service.book.response;

public record BookListResponse(
    Long id,
    String name,
    String description,
    String image,
    String publisher,
    String categoryName


) {
    public BookListResponse(Long id, String name, String description, String image, String publisher, String categoryName){
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.publisher = publisher;
        this.categoryName = categoryName;
    }
}
