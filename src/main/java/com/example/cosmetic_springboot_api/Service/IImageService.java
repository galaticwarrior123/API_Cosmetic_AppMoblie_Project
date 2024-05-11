package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Entity.Image;

import java.util.List;

public interface IImageService {
    void deleteById (int id);
    List<Image> findAllByProductId(int productId);
}
