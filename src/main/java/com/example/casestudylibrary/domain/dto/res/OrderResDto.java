package com.example.casestudylibrary.domain.dto.res;


import com.example.casestudylibrary.domain.enumration.EStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResDto {
    private Long id;
    private LocalDate borrowDate;
    private LocalDate payDate;
    private Long bookId;
    private EStatus eStatus;
}
