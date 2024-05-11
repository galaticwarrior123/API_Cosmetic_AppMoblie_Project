package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Entity.Image;
import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Service.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final ImageRepository imageRepository;
    @Override
    public void deleteById(int id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<Image> findAllByProductId(int productId) {
        return imageRepository.findAllByProductId(productId);
    }
}
