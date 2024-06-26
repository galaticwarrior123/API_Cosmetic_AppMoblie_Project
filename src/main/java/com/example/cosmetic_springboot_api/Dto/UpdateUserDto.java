package com.example.cosmetic_springboot_api.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserDto {
    private String userName;
    private String phone;
    private String gender;
    private String address;
    private String image;
}
