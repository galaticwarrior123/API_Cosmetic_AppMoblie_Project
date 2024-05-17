package com.example.cosmetic_springboot_api.Dto;


import com.example.cosmetic_springboot_api.Entity.Cart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Cart cart;
    private String address;
    private String phone;
    private Long total;
}
