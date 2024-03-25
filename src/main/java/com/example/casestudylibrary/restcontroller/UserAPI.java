package com.example.casestudylibrary.restcontroller;

import com.example.casestudylibrary.model.dto.req.CategoryReqDto;
import com.example.casestudylibrary.model.dto.req.UserReqDto;
import com.example.casestudylibrary.model.dto.res.CategoryResDto;
import com.example.casestudylibrary.model.dto.res.UserResDto;
import com.example.casestudylibrary.repository.IUserRepository;
import com.example.casestudylibrary.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserAPI {
    @Autowired
    private IUserService userService;
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        UserResDto userResDto = userService.findById(id);
        return new ResponseEntity<>(userResDto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserReqDto userReqDto) {
        UserResDto userResDto = userService.save(userReqDto);
        return new ResponseEntity<>(userResDto, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResDto> update(@PathVariable Long id, @RequestBody UserReqDto userReqDto) {
        UserResDto updatedUser = userService.update(id, userReqDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("User with ID " + id + " deleted successfully.", HttpStatus.OK);
    }

}
