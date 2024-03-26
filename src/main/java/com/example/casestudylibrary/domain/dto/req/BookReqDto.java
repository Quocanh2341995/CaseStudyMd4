package com.example.casestudylibrary.domain.dto.req;

import com.example.casestudylibrary.domain.File;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookReqDto {

    private String name;
    private String description;
    private String publisher;
    private String status;
    private String categoryId;
}
