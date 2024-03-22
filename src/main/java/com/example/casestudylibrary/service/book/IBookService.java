package com.example.casestudylibrary.service.book;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.service.book.request.BookSaveRequest;
import com.example.casestudylibrary.service.book.response.BookDetailResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllWithSearch(String search, Long categoryId, Pageable pageable);
    void create (BookSaveRequest request);
    void update (BookSaveRequest request, Long id) throws JsonMappingException;
    void delete (Long id);
    Book findBookById(Long id);
    BookDetailResponse findBookDetailById(Long id);
    long count();
    void init();
}
