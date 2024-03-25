package com.example.casestudylibrary.service;


import com.example.casestudylibrary.domain.Book;
import com.example.casestudylibrary.domain.dto.req.BookReqDto;
import com.example.casestudylibrary.domain.dto.res.BookResDto;

public interface IBookService {
    Book findById(Long id);
    BookResDto findDetailsById(Long id);
    void create(BookReqDto bookReqDto);
    void deleteById(Long id);
    void updateById(Long id, BookReqDto bookReqDto);


}
