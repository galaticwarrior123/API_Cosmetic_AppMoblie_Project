package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.BrandDto;
import com.example.cosmetic_springboot_api.Entity.Brand;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Repository.BrandRepository;
import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Repository.ProductRepository;
import com.example.cosmetic_springboot_api.Response.BrandResponse;
import com.example.cosmetic_springboot_api.Service.IBrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements IBrandService {

    private final BrandRepository brandRepository ;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<BrandResponse> getAllBrand() {
        return brandRepository.findAll()
                .stream().map(brand -> modelMapper.map(brand, BrandResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public BrandResponse updateBrand(int id, BrandDto brandDto) {
        Brand updateBrand = brandRepository.findById(id).get();
        updateBrand.setName(brandDto.getName());
        brandRepository.save(updateBrand);
        return modelMapper.map(updateBrand, BrandResponse.class);
    }

    @Override
    public BrandResponse addBrand(BrandDto brandDto) {
        modelMapper.typeMap(BrandDto.class, Brand.class)
                .addMappings(mapper -> mapper.skip(Brand::setId));
        Brand brand = new Brand();
        modelMapper.map(brandDto,brand);
        brandRepository.save(brand);
        return modelMapper.map(brand, BrandResponse.class);
    }

    @Override
    public void deleteBrand(int id) {
        List<Product> products = productRepository.findProductsByBrand_Id(id);
        for (Product product : products) {
            imageRepository.deleteAllByProductId(product.getId());
        }
        productRepository.deleteProductByBrand_Id(id);
        brandRepository.deleteById(id);
    }
}
