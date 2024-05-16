package com.example.cosmetic_springboot_api.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserDto {
    private String email;
    private String password;
}
