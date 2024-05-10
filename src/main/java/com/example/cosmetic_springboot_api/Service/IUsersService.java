package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.UsersResponse;

public interface IUsersService {
    UsersResponse registerUser(UsersDto usersDto);
}
