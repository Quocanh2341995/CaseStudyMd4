package com.example.casestudylibrary.service;

import com.example.casestudylibrary.model.Book;
import com.example.casestudylibrary.model.dto.req.BookReqDto;
import com.example.casestudylibrary.model.dto.res.BookResDto;

public interface IBookService {
    Book findById(Long id);
    BookResDto findDetailsById(Long id);
    void create(BookReqDto bookReqDto);
    void deleteById(Long id);
    void updateById(Long id, BookReqDto bookReqDto);


}
