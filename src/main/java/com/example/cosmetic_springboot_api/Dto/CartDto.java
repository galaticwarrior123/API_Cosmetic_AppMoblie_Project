package com.example.cosmetic_springboot_api.Dto;


import com.example.cosmetic_springboot_api.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {
    private float totalPrice;
    private int totalQuantity;
}
