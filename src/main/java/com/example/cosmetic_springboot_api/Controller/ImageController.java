package com.example.cosmetic_springboot_api.Controller;


import com.example.cosmetic_springboot_api.Service.IImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image/")
@RequiredArgsConstructor
public class ImageController {
    private final IImageService imageService;
    @DeleteMapping("{id}")
    public void deleteImage(@PathVariable int id){
        imageService.deleteById(id);
    }
}
