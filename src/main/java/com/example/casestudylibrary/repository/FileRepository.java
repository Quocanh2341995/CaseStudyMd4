package com.example.casestudylibrary.repository;

import com.example.casestudylibrary.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {
}
