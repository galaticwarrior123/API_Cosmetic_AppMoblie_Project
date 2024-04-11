package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Entity.Image;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Repository.ProductRepository;
import com.example.cosmetic_springboot_api.Response.ProductResponse;
import com.example.cosmetic_springboot_api.Service.IProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ImageRepository imageRepository;
    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream().map(product -> {
                    ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
                    productResponse.setImages(imageRepository.findAllByProduct(product.getId()));
                    return productResponse;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse addProduct(ProductDto productDto) {
        // Lưu sản phẩm thêm vào bảng product và ảnh của sản phẩm đã thêm vào bảng image
        Product product = new Product();
        modelMapper.map(productDto, product);
        productRepository.save(product);
        List<Image> images = productDto.getImages().stream().map(imageDto -> {
            Image image = new Image();
            image.setUrl(imageDto);
            image.setProduct(product);
            return image;
        }).collect(Collectors.toList());
        imageRepository.saveAll(images);
        ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
        productResponse.setImages(images);
        return productResponse;


    }

    @Override
    public Product updateProduct(int id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(int id) {

    }
}
