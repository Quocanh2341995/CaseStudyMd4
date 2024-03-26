package com.example.casestudylibrary.domain.dto.res;

import com.example.casestudylibrary.domain.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileResDto {
    private String id;
    private String fileName;
    private String fileFolder;

    private String fileUrl;

    private String fileType;

    private String cloudId;


}
