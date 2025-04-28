package com.exercises.backend.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercises.backend.model.Product;
import com.exercises.backend.services.product.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	private final ProductService productService;

    public ProductController() {
        this.productService = new ProductService();
    }

    @PostMapping("/average-by-category")
    public Map<String, Double> getAveragePriceByCategory(@RequestBody List<Product> products) {
        return productService.calculateAveragePricePerCategory(products);
    }

}
