package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Service.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final ImageRepository imageRepository;
    @Override
    public void deleteById(int id) {
        imageRepository.deleteById(id);
    }
}
