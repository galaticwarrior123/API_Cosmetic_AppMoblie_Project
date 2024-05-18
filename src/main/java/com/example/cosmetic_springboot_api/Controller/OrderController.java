package com.example.cosmetic_springboot_api.Controller;


import com.example.cosmetic_springboot_api.Dto.OrderDto;
import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.OrderResponse;
import com.example.cosmetic_springboot_api.Service.ICartService;
import com.example.cosmetic_springboot_api.Service.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final IOrderService orderService;
    private final ModelMapper modelMapper;

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<OrderResponse>> getAllOrderByUserId(@PathVariable int userId){
        return ResponseEntity.ok(orderService.getAllOrderByUserId(userId));
    }

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable int id, @Valid @RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.updateOrder(id, orderDto));
    }

    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<OrderResponse> updateStatusOrderById(@PathVariable int orderId){
        return ResponseEntity.ok(orderService.updateStatusOrderById(orderId));
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable int orderId){
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }
}
