package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.CartDto;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.CartResponse;

import java.util.List;

public interface ICartService {
    CartResponse addCart(Users user);
    List<CartResponse> getAllCartByUserId(Users user);

    CartResponse updateCart(int cartId,CartDto cartDto);

    CartResponse getCartById(int cartId);

}
