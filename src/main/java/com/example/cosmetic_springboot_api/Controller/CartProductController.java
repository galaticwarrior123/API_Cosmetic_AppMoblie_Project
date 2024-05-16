package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.CartProductDto;
import com.example.cosmetic_springboot_api.Response.CartProductResponse;
import com.example.cosmetic_springboot_api.Response.CartResponse;
import com.example.cosmetic_springboot_api.Service.ICartProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cartProduct/")
public class CartProductController {
    private final ICartProductService cartProductService;
    private final ModelMapper modelMapper;

    @PostMapping("/add")
    public ResponseEntity<CartProductResponse> addCartProduct(@Valid @RequestBody CartProductDto cartProductDto){
        return ResponseEntity.ok(modelMapper.map(cartProductService.addCartProduct(cartProductDto), CartProductResponse.class));
    }
    @PutMapping("/update/{cartProductId}")
    public ResponseEntity<CartProductResponse> updateCartProduct(@Valid @RequestBody CartProductDto cartProductDto, @PathVariable int cartProductId){
        return ResponseEntity.ok(modelMapper.map(cartProductService.updateCartProduct(cartProductDto, cartProductId), CartProductResponse.class));
    }
    @DeleteMapping("/delete/{cartProductId}")
    public ResponseEntity<Void> deleteCartProduct(@PathVariable int cartProductId){
        cartProductService.deleteCartProduct(cartProductId);
        return ResponseEntity.ok().build();
    }
}
