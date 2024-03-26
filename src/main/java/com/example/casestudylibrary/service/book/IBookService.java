package com.example.casestudylibrary.service.book;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.dto.req.BookReqDto;
import com.example.casestudylibrary.service.book.response.BookDetailResponse;
import com.example.casestudylibrary.service.book.response.BookListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IBookService {
    Page<Book> findAllWithSearch(String search, Long categoryId, Pageable pageable);

    void create (BookReqDto request, MultipartFile img) throws IOException;
    void update (BookReqDto request, Long id, MultipartFile img) throws IOException;
    void delete (Long id);
    Book findBookById(Long id);
    BookDetailResponse findBookDetailById(Long id);
    List<BookListResponse> findAll();
}
