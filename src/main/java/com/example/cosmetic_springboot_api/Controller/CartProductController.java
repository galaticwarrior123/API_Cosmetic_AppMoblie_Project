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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cartProduct/")
public class CartProductController {
    private final ICartProductService cartProductService;
    private final ModelMapper modelMapper;


    @GetMapping("/all/{cartId}")
    public ResponseEntity<List<CartProductResponse>> getAllCartProductByCartId(@PathVariable int cartId){
        return ResponseEntity.ok(cartProductService.getAllCartProductByCartId(cartId));
    }

    @GetMapping("/get/{cartProductId}")
    public ResponseEntity<CartProductResponse> getCartProductById(@PathVariable int cartProductId){
        return ResponseEntity.ok(cartProductService.getCartProductById(cartProductId));
    }

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
