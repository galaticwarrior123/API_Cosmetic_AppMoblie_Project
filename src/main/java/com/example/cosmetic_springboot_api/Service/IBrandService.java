package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.BrandDto;
import com.example.cosmetic_springboot_api.Response.BrandResponse;

import java.util.List;

public interface IBrandService {
    List<BrandResponse> getAllBrand();
    BrandResponse updateBrand(int id, BrandResponse brandResponse);
    BrandResponse addBrand(BrandDto brandDto);
    void deleteBrand(int id);
}
