package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.LoginUserDto;
import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.UserLoginResponse;
import com.example.cosmetic_springboot_api.Response.UsersResponse;

import java.util.List;

public interface IUsersService {
    UsersResponse registerUser(UsersDto usersDto);

    UserLoginResponse loginUser(LoginUserDto loginUserDto);

    List<UsersResponse> getAllUsers();

    UsersResponse getUserById(int id);

    UsersResponse updateStatusUser(int id);

    UsersResponse updateUser(int id);
}
