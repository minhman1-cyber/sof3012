package com.example.sof3012.services;

import com.example.sof3012.entity.Category;
import com.example.sof3012.repository.CategoryRepo;

import java.util.List;

public class CategoryService {
    CategoryRepo categoryRepo = new CategoryRepo();
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category findById(Long id) {
        return categoryRepo.findById(id);
    }
}
