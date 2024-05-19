package com.example.cosmetic_springboot_api.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int id;
    private CartResponse cart;
    private LocalDateTime orderDate;
    private boolean status;

}
