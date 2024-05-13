package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Repository.UsersRepository;
import com.example.cosmetic_springboot_api.Response.UsersResponse;
import com.example.cosmetic_springboot_api.Service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;
    @Override
    public UsersResponse registerUser(UsersDto usersDto) {
        Users users = new Users();
        users.setUserName(usersDto.getUsername());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());
        modelMapper.map(usersDto, users);
        usersRepository.save(users);
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public List<UsersResponse> getAllUsers() {
        return usersRepository.findAll()
                .stream().map(users -> modelMapper.map(users, UsersResponse.class))
                .collect(java.util.stream.Collectors.toList());

    }
}
