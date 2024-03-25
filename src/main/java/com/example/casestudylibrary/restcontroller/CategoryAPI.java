package com.example.casestudylibrary.restcontroller;

import com.example.casestudylibrary.model.dto.req.CategoryReqDto;
import com.example.casestudylibrary.model.dto.res.CategoryResDto;
import com.example.casestudylibrary.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryAPI {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategoryReqDto categoryReqDto) {
        CategoryResDto categoryResDto = categoryService.save(categoryReqDto);
        return new ResponseEntity<>(categoryResDto, HttpStatus.CREATED);
    }
}
