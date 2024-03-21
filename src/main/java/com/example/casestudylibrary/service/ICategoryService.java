package com.example.casestudylibrary.service;

import com.example.casestudylibrary.model.Category;
import com.example.casestudylibrary.model.dto.req.CategoryReqDto;
import com.example.casestudylibrary.model.dto.res.CategoryResDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryResDto> findAll();
    void save(CategoryReqDto categoryReqDto);
    void deleteById(Long id);
    void updateById(Long id, CategoryReqDto categoryReqDto);

    CategoryResDto findById(Long id);
}
