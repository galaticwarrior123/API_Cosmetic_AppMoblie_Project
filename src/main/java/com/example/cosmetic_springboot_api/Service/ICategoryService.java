package com.example.cosmetic_springboot_api.Service;

import com.example.cosmetic_springboot_api.Dto.CategoryDto;
import com.example.cosmetic_springboot_api.Entity.Category;
import com.example.cosmetic_springboot_api.Response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategory();
    Category updateCategory(int id, Category category);
    Category addCategory(CategoryDto categoryDto);
    void deleteCategory(int id);

}
