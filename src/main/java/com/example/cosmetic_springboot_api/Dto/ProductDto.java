package com.example.cosmetic_springboot_api.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String description;
    private Long price;
    private int stock;
    private List<String> images;
    private int brandId;
    private int categoryId;
}
