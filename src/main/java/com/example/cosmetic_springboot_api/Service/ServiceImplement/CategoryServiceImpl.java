package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.CategoryDto;
import com.example.cosmetic_springboot_api.Entity.Category;
import com.example.cosmetic_springboot_api.Entity.Product;
import com.example.cosmetic_springboot_api.Repository.CategoryRepository;
import com.example.cosmetic_springboot_api.Repository.ImageRepository;
import com.example.cosmetic_springboot_api.Repository.ProductRepository;
import com.example.cosmetic_springboot_api.Response.CategoryResponse;
import com.example.cosmetic_springboot_api.Service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final ImageRepository imageRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll()
                .stream().map(category -> modelMapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Category updateCategory(int id, CategoryDto categoryDto) {
        Category updateCategory = categoryRepository.findById(id).get();
        updateCategory.setName(categoryDto.getName());
        categoryRepository.save(updateCategory);
        return updateCategory;
    }

    @Override
    public CategoryResponse addCategory(CategoryDto categoryDto) {
        System.out.println(categoryDto);
        Category category = new Category();
        modelMapper.map(categoryDto, category);
        categoryRepository.save(category);
        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public void deleteCategory(int id) {
        List<Product> products = productRepository.findProductsByCategory_Id(id);
        for (Product product : products) {
            imageRepository.deleteAllByProductId(product.getId());
        }
        productRepository.deleteProductByCategory_Id(id);
        categoryRepository.deleteById(id);
    }
}
