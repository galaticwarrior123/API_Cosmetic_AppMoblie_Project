package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Entity.Image;
import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Service.IImageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements IImageService {

    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    @Override
    public void deleteById(int id) {
        imageRepository.deleteById(id);
    }

    @Override
    public List<String> findAllByProductId(int productId) {
        List<Image> images = imageRepository.findAllByProductId(productId);
        return images.stream().map(image -> image.getUrl()).toList();

    }
}
