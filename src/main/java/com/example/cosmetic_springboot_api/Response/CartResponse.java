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
    private int totalQuantity;
    private Long price;
    private boolean status;
    private boolean paid;
    private UsersResponse users;
}
