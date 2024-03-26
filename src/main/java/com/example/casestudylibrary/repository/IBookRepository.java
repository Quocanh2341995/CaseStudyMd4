package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.service.book.response.BookListResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query ("SELECT " +
            "new com.example.casestudylibrary.service.book.response.BookListResponse(b.id, b.name, b.description, b.poster.fileUrl, b.publisher, b.category.name)" +
            "FROM Book  b")
    List<BookListResponse> getAllBookResDto();
}
