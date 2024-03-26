package com.example.casestudylibrary.service.book;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.dto.res.BookResDto;
import com.example.casestudylibrary.service.book.request.BookSaveRequest;
import com.example.casestudylibrary.service.book.response.BookDetailResponse;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<BookResDto> findAll();
    Page<Book> findAllWithSearch(String search, Long categoryId, Pageable pageable);
    void create (BookSaveRequest request);
    void update (BookSaveRequest request, Long id) throws JsonMappingException;
    void delete (Long id);
    Book findBookById(Long id);
    BookDetailResponse findBookDetailById(Long id);
    long count();
    void init();
}
