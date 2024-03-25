package com.example.casestudylibrary.service;

import com.example.casestudylibrary.model.dto.req.CategoryReqDto;
import com.example.casestudylibrary.model.dto.req.UserReqDto;
import com.example.casestudylibrary.model.dto.res.CategoryResDto;
import com.example.casestudylibrary.model.dto.res.UserResDto;

import java.util.List;

public interface IUserService {
    List<UserResDto> findAll();
    UserResDto save(UserReqDto userReqDto);
    void delete(Long id);
    UserResDto findById(Long id);
    UserResDto update(Long id, UserReqDto userReqDto);

//    UserResDto findCurrentUser();
}
