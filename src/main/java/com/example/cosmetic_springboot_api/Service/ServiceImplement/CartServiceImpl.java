package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.CartDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Repository.CartRepository;
import com.example.cosmetic_springboot_api.Repository.UsersRepository;
import com.example.cosmetic_springboot_api.Response.CartResponse;
import com.example.cosmetic_springboot_api.Service.ICartService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements ICartService {
    private final CartRepository cartRepository;
    private final ModelMapper modelMapper;
    private final UsersRepository usersRepository;
    @Override
    public CartResponse addCart(Users user) {
        Cart cart = new Cart();
        cart.setUsers(user);
        cartRepository.save(cart);
        return modelMapper.map(cart, CartResponse.class);
    }

    @Override
    public List<CartResponse> getAllCartByUserId(Users user) {
        return cartRepository.findCartsByUsers_Id(user.getId())
                .stream().map(cart -> modelMapper.map(cart, CartResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CartResponse updateCart(int cartId,CartDto cartDto) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if(cart == null){
            return null;
        }
        cart.setTotalQuantity(cartDto.getTotalQuantity());
        cartRepository.save(cart);
        return modelMapper.map(cart, CartResponse.class);
    }
}
