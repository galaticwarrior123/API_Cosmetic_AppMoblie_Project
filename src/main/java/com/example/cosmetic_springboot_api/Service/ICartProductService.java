package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.CartProductDto;
import com.example.cosmetic_springboot_api.Entity.Cart_product;
import com.example.cosmetic_springboot_api.Response.CartProductResponse;

public interface ICartProductService {
    Cart_product addCartProduct(CartProductDto cartProductDto);

    void deleteCartProduct(int cartProductId);

    Cart_product updateCartProduct(CartProductDto cartProductDto, int cartProductId);
}
