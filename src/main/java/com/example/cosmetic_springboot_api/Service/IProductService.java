package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Response.ProductResponse;

import java.util.List;

public interface IProductService {
    List<ProductResponse> getAllProduct();
    List<ProductResponse> getAllProductByCategory(int categoryId);
    ProductResponse addProduct(ProductDto productDto);
    ProductResponse updateProduct(int id, ProductDto productDto);
    void deleteProduct(int id);
}
