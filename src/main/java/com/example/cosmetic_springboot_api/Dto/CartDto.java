package com.example.cosmetic_springboot_api.Dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    private int id;
    private int productId;
    private int quantity;
    private int userId;
    private int orderId;
    private boolean status;
}
