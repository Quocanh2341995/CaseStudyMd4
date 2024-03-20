package com.example.casestudylibrary.service.impl;

import com.example.casestudylibrary.model.Book;
import com.example.casestudylibrary.model.dto.req.BookReqDto;
import com.example.casestudylibrary.model.dto.res.BookResDto;
import com.example.casestudylibrary.repository.IBookRepository;
import com.example.casestudylibrary.repository.ICategoryRepository;
import com.example.casestudylibrary.service.IBookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository bookRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public BookResDto findDetailsById(Long id) {
        Book book = bookRepository.findById(id).orElse(null);
        return book.toBookResDto();
    }

    @Override
    public void create(BookReqDto bookReqDto) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateById(Long id, BookReqDto bookReqDto) {

    }
}
