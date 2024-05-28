package com.scaler_04.e_commerce_24th_may.service;

import com.scaler_04.e_commerce_24th_may.dto.CategoryDTO;
import com.scaler_04.e_commerce_24th_may.model.Category;
import com.scaler_04.e_commerce_24th_may.model.CategoryMapper;
import com.scaler_04.e_commerce_24th_may.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryMapper::toCategoryDTO).collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryMapper.toCategoryDTO(category);
    }
}
