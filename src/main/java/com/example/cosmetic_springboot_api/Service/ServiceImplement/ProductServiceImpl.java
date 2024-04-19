package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.ProductDto;
import com.example.cosmetic_springboot_api.Entity.Brand;
import com.example.cosmetic_springboot_api.Entity.Category;
import com.example.cosmetic_springboot_api.Entity.Image;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Repository.BrandRepository;
import com.example.cosmetic_springboot_api.Repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;
    @Override
    public List<ProductResponse> getAllProduct() {
        return productRepository.findAll()
                .stream().map(product -> {
                    ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
                    productResponse.setImages(imageRepository.findAllURLByProduct(product.getId()));
                    return productResponse;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getAllProductByCategory(int categoryId) {
        return productRepository.findProductsByCategory_Id(categoryId)
                .stream().map(product -> {
                    ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
                    productResponse.setImages(imageRepository.findAllURLByProduct(product.getId()));
                    return productResponse;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse addProduct(ProductDto productDto) {

        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        System.out.println("price"+productDto.getPrice());
        System.out.println("brandID"+productDto.getBrandId());
        Brand brand= new Brand();
        brand.setId(productDto.getBrandId());
        product.setBrand(brand);
        System.out.println("cateID"+productDto.getCategoryId());
        Category category = new Category();
        category.setId(productDto.getCategoryId());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        product.setStatus(true);
        product.setStock(productDto.getStock());
        productRepository.save(product);
        List<Image> images = productDto.getImages().stream().map(imageUrl -> {
                    Image image = new Image();
                    image.setUrl(imageUrl);
                    image.setProduct(product);
                    return image;
                }).collect(Collectors.toList());
        imageRepository.saveAll(images);
        ProductResponse productResponse = modelMapper.map(product, ProductResponse.class);
        productResponse.setImages(images.stream().map(Image::getUrl).collect(Collectors.toList()));
        return productResponse;
    }

    @Override
    public ProductResponse updateProduct(int id, ProductDto productDto) {
        Product updateProduct = productRepository.findById(id).get();
        updateProduct.setName(productDto.getName());
        updateProduct.setPrice(productDto.getPrice());
        updateProduct.setBrand(brandRepository.findById(productDto.getBrandId()).orElse(null));
        updateProduct.setCategory(categoryRepository.findById(productDto.getCategoryId()).orElse(null));
        updateProduct.setDescription(productDto.getDescription());
        updateProduct.setStatus(true);
        updateProduct.setStock(productDto.getStock());
        productRepository.save(updateProduct);
        List<Image> images = productDto.getImages().stream().map(imageUrl -> {
            Image image = new Image();
            image.setUrl(imageUrl);
            image.setProduct(updateProduct);
            return image;
        }).collect(Collectors.toList());
        imageRepository.saveAll(images);
        ProductResponse productResponse = modelMapper.map(updateProduct, ProductResponse.class);
        productResponse.setImages(images.stream().map(Image::getUrl).collect(Collectors.toList()));
        return productResponse;
    }

    @Override
    public void deleteProduct(int id) {
        imageRepository.deleteAllByProductId(id);
        productRepository.deleteById(id);
    }
}
