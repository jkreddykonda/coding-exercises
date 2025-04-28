package com.exercises.backend.services.product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.exercises.backend.model.Product;

public class ProductService {
	
	public Map<String, Double> calculateAveragePricePerCategory(List<Product> products) {
        return products.stream()
                .collect(Collectors.groupingBy(
                        Product::category,
                        Collectors.averagingDouble(p -> p.price())
                ));
    }

}
