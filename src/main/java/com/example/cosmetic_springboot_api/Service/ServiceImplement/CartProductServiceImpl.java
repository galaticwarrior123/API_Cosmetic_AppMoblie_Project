package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.CartProductDto;
import com.example.cosmetic_springboot_api.Entity.Cart;
import com.example.cosmetic_springboot_api.Entity.Cart_product;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Repository.CartProductRepository;
import com.example.cosmetic_springboot_api.Repository.CartRepository;
import com.example.cosmetic_springboot_api.Repository.ProductRepository;
import com.example.cosmetic_springboot_api.Response.CartProductResponse;
import com.example.cosmetic_springboot_api.Service.ICartProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartProductServiceImpl implements ICartProductService {
    private final CartRepository cartRepository;
    private final CartProductRepository cartProductRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public Cart_product addCartProduct(CartProductDto cartProductDto) {
        System.out.println(cartProductDto.getQuantity());
        Cart cart = cartRepository.findById(cartProductDto.getCartId()).orElse(null);
        Product product = productRepository.findById(cartProductDto.getProductId()).orElse(null);
        if (cart == null || product == null) {
            return null;
        }
        Cart_product cartProduct = new Cart_product();
        cartProduct.setCart(cart);
        cartProduct.setProduct(product);
        cartProduct.setQuantity(cartProductDto.getQuantity());
        cartProductRepository.save(cartProduct);
        return cartProduct;
    }

    @Override
    public void deleteCartProduct(int cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }

    @Override
    public Cart_product updateCartProduct(CartProductDto cartProductDt, int cartProductId) {
        Cart_product cartProduct = cartProductRepository.findById(cartProductId).orElse(null);
        if (cartProduct == null) {
            return null;
        }
        cartProduct.setQuantity(cartProductDt.getQuantity());
        cartProductRepository.save(cartProduct);
        return cartProduct;
    }

    @Override
    public List<CartProductResponse> getAllCartProductByCartId(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElse(null);
        if (cart == null) {
            return null;
        }
        List<Cart_product> cartProducts = cartProductRepository.findAllByCart(cart);
        return cartProducts.stream().map(cartProduct -> modelMapper.map(cartProduct, CartProductResponse.class)).toList();
    }
}
