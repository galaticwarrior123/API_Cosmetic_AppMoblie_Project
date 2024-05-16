package com.example.cosmetic_springboot_api.Controller;


import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Response.OrderResponse;
import com.example.cosmetic_springboot_api.Service.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody Cart cart){
        return ResponseEntity.ok(orderService.createOrder(cart));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<OrderResponse> updateOrder(@PathVariable int id, @Valid @RequestBody Cart cart){
        return ResponseEntity.ok(orderService.updateOrder(id, cart));
    }

    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<OrderResponse> updateStatusOrderById(@PathVariable int orderId){
        return ResponseEntity.ok(orderService.updateStatusOrderById(orderId));
    }
}
