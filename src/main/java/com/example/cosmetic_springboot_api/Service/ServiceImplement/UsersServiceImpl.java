package com.example.cosmetic_springboot_api.Service.ServiceImplement;


import com.example.cosmetic_springboot_api.Component.JwtTokenUtil;
import com.example.cosmetic_springboot_api.Dto.LoginUserDto;
import com.example.cosmetic_springboot_api.Dto.UpdateUserDto;
import com.example.cosmetic_springboot_api.Dto.UsersDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Repository.CartRepository;
import com.example.cosmetic_springboot_api.Repository.UsersRepository;
import com.example.cosmetic_springboot_api.Response.UserLoginResponse;
import com.example.cosmetic_springboot_api.Response.UsersResponse;
import com.example.cosmetic_springboot_api.Service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService {
    private final UsersRepository usersRepository;
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public UsersResponse registerUser(UsersDto usersDto) {
        if(usersRepository.findByEmail(usersDto.getEmail()).isPresent()){
            return null;
        }
        Users users = modelMapper.map(usersDto, Users.class);
        users.setPassword(bCryptPasswordEncoder.encode(usersDto.getPassword()));
        usersRepository.save(users);
        Cart cart = new Cart();
        cart.setUsers(users);
        cartRepository.save(cart);
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public UserLoginResponse loginUser(LoginUserDto loginUserDto) {
        Optional<Users> users = usersRepository.findByEmail(loginUserDto.getEmail());
        if(users.isEmpty()){
            return null;
        }
        Users user = users.get();
        if(!bCryptPasswordEncoder.matches(loginUserDto.getPassword(), user.getPassword())){
            return null;
        }
        if(!user.isStatus()){
            return null;
        }
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword(), user.getAuthorities()));
        String token = jwtTokenUtil.generateToken(user);
        return new UserLoginResponse(modelMapper.map(user, UsersResponse.class), token);
    }

    @Override
    public List<UsersResponse> getAllUsers() {
        return usersRepository.findAll()
                .stream().map(users -> modelMapper.map(users, UsersResponse.class))
                .collect(java.util.stream.Collectors.toList());

    }

    @Override
    public UsersResponse getUserById(int id) {
        Users users = usersRepository.findById(id).get();
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public UsersResponse updateStatusUser(int id) {
        Users users = usersRepository.findById(id).get();
        users.setStatus(!users.isStatus());
        usersRepository.save(users);
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public UsersResponse updateUser(int id, UpdateUserDto updateusersDto) {
        Users users = usersRepository.findById(id).get();
        users.setUserName(updateusersDto.getUserName());
        users.setPhone(updateusersDto.getPhone());
        users.setAddress(updateusersDto.getAddress());
        users.setGender(updateusersDto.getGender());
        users.setImage(updateusersDto.getImage());
        usersRepository.save(users);
        return modelMapper.map(users, UsersResponse.class);
    }

    @Override
    public void changePassword(int id, String oldPassword, String newPassword) {
        Users users = usersRepository.findById(id).get();
        if(bCryptPasswordEncoder.matches(oldPassword, users.getPassword())){
            users.setPassword(bCryptPasswordEncoder.encode(newPassword));
            usersRepository.save(users);
        }
        else{
            throw new RuntimeException("Old password is incorrect");
        }
    }
}
