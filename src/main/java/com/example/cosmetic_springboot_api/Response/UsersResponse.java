package com.example.cosmetic_springboot_api.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UsersResponse {
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private String image;
    private boolean isAdmin;
}
