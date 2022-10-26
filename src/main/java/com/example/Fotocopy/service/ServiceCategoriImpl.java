package com.example.Fotocopy.service;

import com.example.Fotocopy.model.Category;
import com.example.Fotocopy.repo.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@Transactional
public class ServiceCategoriImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public Category getCategoryId(Long idCategory) {
        return categoryRepository.findById(idCategory).get();
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long idCategory, Category category) {
        Category category1 = categoryRepository.findById(idCategory).get();
        category1.setCategoryName(category.getCategoryName());
        categoryRepository.save(category1);
    }

    @Override
    public void deleteCategory(Long idCategory) {
        categoryRepository.deleteById(idCategory);
    }
}
