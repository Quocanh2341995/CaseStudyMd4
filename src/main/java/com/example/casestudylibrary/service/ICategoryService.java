package com.example.casestudylibrary.service;


import com.example.casestudylibrary.domain.dto.req.CategoryReqDto;
import com.example.casestudylibrary.domain.dto.res.CategoryResDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryResDto> findAll();
    void save(CategoryReqDto categoryReqDto);
    void deleteById(Long id);
    void updateById(Long id, CategoryReqDto categoryReqDto);

    CategoryResDto findById(Long id);
}
