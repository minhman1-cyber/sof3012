package com.example.sof3012.repository;

import com.example.sof3012.entity.Category;
import com.example.sof3012.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class CategoryRepo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<Category> findAll() {
        return em.createQuery("select c from Category c", Category.class).getResultList();
    }

    public Category findById(Long id) {
        return em.find(Category.class, id);
    }

}
