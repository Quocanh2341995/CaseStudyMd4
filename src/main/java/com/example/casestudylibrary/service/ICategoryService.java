package com.example.casestudylibrary.service;

import com.example.casestudylibrary.model.dto.req.CategoryReqDto;
import com.example.casestudylibrary.model.dto.res.CategoryResDto;

import java.util.List;

public interface ICategoryService {
    List<CategoryResDto> findAll();
    CategoryResDto save(CategoryReqDto categoryReqDto);
}
