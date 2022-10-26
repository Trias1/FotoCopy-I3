package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryId(Long idCategory);
    List<Category> getAllCategory();
    Category saveCategory(Category category);
    void updateCategory(Long idCategory, Category category);
    void deleteCategory(Long idCategory);
}
