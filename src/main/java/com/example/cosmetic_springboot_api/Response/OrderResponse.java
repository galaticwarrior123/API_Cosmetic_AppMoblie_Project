package com.example.cosmetic_springboot_api.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private int id;
    private CartResponse cart;
    private boolean status;

}
