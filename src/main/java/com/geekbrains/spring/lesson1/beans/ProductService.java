package com.geekbrains.spring.lesson1.beans;

import com.geekbrains.spring.lesson1.Product;
import com.geekbrains.spring.lesson1.beans.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "ProductService")
public class ProductService {
    private ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    public Product getProductById(Long id){
        return productRepo.getProductById(id);
    }

    public List<Product> getAllProducts(){
        return productRepo.getAllProducts();
    }

    public void saveProduct(String name, int price){
        productRepo.saveProduct(name, price);
    }
}