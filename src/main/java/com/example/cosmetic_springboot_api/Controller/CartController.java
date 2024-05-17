package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.CartDto;
import com.example.cosmetic_springboot_api.Entity.Users;
import com.example.cosmetic_springboot_api.Response.CartResponse;
import com.example.cosmetic_springboot_api.Response.UsersResponse;
import com.example.cosmetic_springboot_api.Service.ICartService;
import com.example.cosmetic_springboot_api.Service.IProductService;
import com.example.cosmetic_springboot_api.Service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cart/")
public class CartController {
    private final ICartService cartService;
    private final IProductService productService;
    private final IUsersService usersService;
    private final ModelMapper modelMapper;

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<CartResponse>> getAllCartByUserId(@PathVariable int userId){
        UsersResponse user = usersService.getUserById(userId);
        Users userEntity = modelMapper.map(user, Users.class);
        return ResponseEntity.ok(cartService.getAllCartByUserId(userEntity));
    }

    @PutMapping("/update/{cartId}")
    public ResponseEntity<CartResponse> updateCart(@PathVariable int cartId, @RequestBody CartDto cartDto){
        return ResponseEntity.ok(cartService.updateCart(cartId, cartDto));
    }

}
