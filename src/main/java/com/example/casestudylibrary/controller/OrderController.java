package com.example.casestudylibrary.controller;


import com.example.casestudylibrary.domain.dto.req.OrderReqDto;
import com.example.casestudylibrary.domain.dto.req.StatusOrderReqDto;
import com.example.casestudylibrary.domain.dto.res.OrderResDto;
import com.example.casestudylibrary.service.IOrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrderController {
    private final IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderResDto>> findAll() {
        return new ResponseEntity<>(orderService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderResDto> findOrdeById(@PathVariable Long id) {
        return new ResponseEntity<>(orderService.findOrdeById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody OrderReqDto orderReqDto) {
        orderService.save(orderReqDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @PatchMapping("/{id}/update-status")
    public ResponseEntity<?> updateOrderById(@PathVariable Long id, @RequestBody StatusOrderReqDto statusOrderReqDto) {
        orderService.updateStatusOrderById(id, statusOrderReqDto);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
