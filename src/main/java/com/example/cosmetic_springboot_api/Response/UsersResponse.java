package com.example.cosmetic_springboot_api.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    private boolean status;
    private String token;
    private String gender;
    private String image;
    private boolean isAdmin;
}
