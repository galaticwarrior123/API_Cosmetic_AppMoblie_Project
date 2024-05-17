package com.example.cosmetic_springboot_api.Controller;

import com.example.cosmetic_springboot_api.Dto.CartDto;
import com.example.cosmetic_springboot_api.Dto.CartProductDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Image;
import com.example.cosmetic_springboot_api.Response.CartProductResponse;
import com.example.cosmetic_springboot_api.Response.CartResponse;
import com.example.cosmetic_springboot_api.Response.ProductResponse;
import com.example.cosmetic_springboot_api.Service.ICartProductService;
import com.example.cosmetic_springboot_api.Service.ICartService;
import com.example.cosmetic_springboot_api.Service.IImageService;
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
    private final ICartService cartService;
    private final IImageService imageService;
    private final ModelMapper modelMapper;


    @GetMapping("/all/{cartId}")
    public ResponseEntity<List<CartProductResponse>> getAllCartProductByCartId(@PathVariable int cartId){
        List<CartProductResponse> cartProductResponses = cartProductService.getAllCartProductByCartId(cartId);
        for(CartProductResponse cartProductResponse : cartProductResponses){
            ProductResponse productResponse = modelMapper.map(cartProductResponse.getProduct(), ProductResponse.class);
            productResponse.setImages(imageService.findAllByProductId(productResponse.getId()));
            cartProductResponse.setProduct(productResponse);
        }
        return ResponseEntity.ok(cartProductResponses);
    }

    @GetMapping("/get/{cartProductId}")
    public ResponseEntity<CartProductResponse> getCartProductById(@PathVariable int cartProductId){
        return ResponseEntity.ok(cartProductService.getCartProductById(cartProductId));
    }

    @PostMapping("/add")
    public ResponseEntity<CartProductResponse> addCartProduct(@Valid @RequestBody CartProductDto cartProductDto){
        CartProductResponse cartProductResponse = modelMapper.map(cartProductService.addCartProduct(cartProductDto), CartProductResponse.class);
        CartResponse cartResponse = modelMapper.map(cartService.getCartById(cartProductDto.getCartId()), CartResponse.class);
        cartResponse.setTotalQuantity(cartResponse.getTotalQuantity() + cartProductDto.getQuantity());
        cartResponse.setPrice(cartResponse.getTotalQuantity() + Long.parseLong( cartProductResponse.getProduct().getPrice()) * cartProductDto.getQuantity());
        CartDto cartDto = modelMapper.map(cartResponse, CartDto.class);
        cartService.updateCart(cartProductDto.getCartId(), cartDto);
        ProductResponse productResponse = modelMapper.map(cartProductResponse.getProduct(), ProductResponse.class);
        productResponse.setImages(imageService.findAllByProductId(productResponse.getId()));
        cartProductResponse.setProduct(productResponse);
        return ResponseEntity.ok(cartProductResponse);
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
