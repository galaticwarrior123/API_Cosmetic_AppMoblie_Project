package com.example.cosmetic_springboot_api.Dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private String name;
    private int amount;
}
