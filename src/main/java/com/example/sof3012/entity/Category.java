package com.example.sof3012.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList = new ArrayList<>();

    public List<Product> getProduct() {
        return productList;
    }

    public void addProduct(Product product) {
        this.productList.add(product);
    }

    public void removeProductList(Product product) {
        this.productList.remove(product);
    }

}
