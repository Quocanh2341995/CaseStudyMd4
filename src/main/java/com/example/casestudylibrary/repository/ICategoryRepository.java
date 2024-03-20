package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
