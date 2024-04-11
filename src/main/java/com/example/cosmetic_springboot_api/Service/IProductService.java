package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProduct();
    ProductResponse addProduct(ProductDto productDto);
    Product updateProduct(int id, Product product);
    void deleteProduct(int id);
}
