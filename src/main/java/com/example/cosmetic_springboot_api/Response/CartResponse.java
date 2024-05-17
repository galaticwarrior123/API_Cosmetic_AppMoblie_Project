package com.example.cosmetic_springboot_api.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private int id;
    private List<ProductResponse> product;
    private int quantity;
    private float total;
    private boolean status;
    private UsersResponse user;
}
