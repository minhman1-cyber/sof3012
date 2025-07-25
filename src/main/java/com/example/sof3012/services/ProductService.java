package com.example.sof3012.services;

import com.example.sof3012.entity.Category;
import com.example.sof3012.entity.Product;
import com.example.sof3012.repository.CategoryRepo;
import com.example.sof3012.repository.ProductRepo;

import java.util.List;

public class ProductService {
    ProductRepo productRepo = new ProductRepo();
    CategoryRepo categoryRepo = new CategoryRepo();

    public List<Product> findAll() {
        return productRepo.findAll();
    }

    public void them(Long id, String name, Category category) {
        Product product = new Product(id, name, category);
        productRepo.them(product);
    }

    public void sua(Long id, String name, Category category) {
        Product product = new Product(id, name, category);
        productRepo.sua(product);
    }

    public void xoa(Long id) {
        productRepo.xoa(id);
    }

    public Product getProduct(Long id) {
        return productRepo.findById(id);
    }

    public Long countProductByKeyword(String keyword) {
        return productRepo.countProductByKeyword(keyword);
    }

    public Long countProduct(){
        return productRepo.countProduct();
    }

    public List<Product> getProductByKeywordAndPage(String keyword, int page, int size) {
        return productRepo.getProductByKeywordAndPage(keyword, page, size);
    }

    public List<Product> getProductByPage(int page, int size) {
        return productRepo.getProductByPage(page, size);
    }


}
