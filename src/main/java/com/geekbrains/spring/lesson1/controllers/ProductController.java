package com.geekbrains.spring.lesson1.controllers;

import com.geekbrains.spring.lesson1.models.Product;
import com.geekbrains.spring.lesson1.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("Products", productService.getAllProducts());
        return "all_products";
    }

    @GetMapping("/show_product/{id}")
    public String getProductById(@PathVariable Long id, Model model) {
        model.addAttribute("Products", productService.getProductById(id));
        return "product_page";
    }

    @GetMapping("/add")
    public String showProductAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }

}