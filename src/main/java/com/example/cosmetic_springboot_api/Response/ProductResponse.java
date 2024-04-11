package com.example.cosmetic_springboot_api.Response;

import com.example.cosmetic_springboot_api.Entity.Brand;
import com.example.cosmetic_springboot_api.Entity.Category;
import com.example.cosmetic_springboot_api.Entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int id;
    private String name;
    private String description;
    private String price;
    private int stock;
    private List<String> images;
    private Category category;
    private Brand brand;
}
