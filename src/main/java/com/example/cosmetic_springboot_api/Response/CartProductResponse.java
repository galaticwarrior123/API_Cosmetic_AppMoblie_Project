package com.example.cosmetic_springboot_api.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductResponse {
    private int id;
    private int quantity;;
    private ProductResponse product;
    private CartResponse cart;
}
