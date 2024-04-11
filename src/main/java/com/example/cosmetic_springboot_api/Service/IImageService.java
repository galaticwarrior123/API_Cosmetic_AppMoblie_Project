package com.example.cosmetic_springboot_api.Service;

import java.util.List;

public interface IImageService {
    List<String> getAllImageByProduct(int productId);
}
