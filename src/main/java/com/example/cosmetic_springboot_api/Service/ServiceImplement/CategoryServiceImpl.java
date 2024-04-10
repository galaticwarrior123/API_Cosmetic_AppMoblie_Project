package com.example.cosmetic_springboot_api.Service.ServiceImplement;

import com.example.cosmetic_springboot_api.Dto.CategoryDto;
import com.example.cosmetic_springboot_api.Entity.Category;
import com.example.cosmetic_springboot_api.Repository.CategoryRepository;
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
    private final ModelMapper modelMapper;
    @Override
    public List<CategoryResponse> getAllCategory() {
        return categoryRepository.findAll()
                .stream().map(category -> modelMapper.map(category, CategoryResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Category updateCategory(int id, Category category) {
        return null;
    }

    @Override
    public Category addCategory(CategoryDto categoryDto) {
        modelMapper.typeMap(CategoryDto.class, Category.class)
                .addMappings(mapper -> mapper.skip(Category::setId));
        Category category = new Category();
        modelMapper.map(categoryDto,category);
        categoryRepository.save(category);
        return modelMapper.map(category, Category.class);
    }

    @Override
    public void deleteCategory(int id) {

    }
}
