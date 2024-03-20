package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
