package com.exercises.backend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.exercises.backend.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ProductController.class)  // ✅ Proper WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper(); // ✅ Fine to create manually

    @Test
    @DisplayName("Should calculate average price by category successfully")
    void testAveragePriceByCategory() throws Exception {
        // Arrange
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 1000.0),
                new Product("MacBook", "Electronics", 2000.0),
                new Product("Chair", "Furniture", 300.0),
                new Product("Table", "Furniture", 500.0)
        );

        String inputJson = objectMapper.writeValueAsString(products);

        // Act & Assert
        mockMvc.perform(post("/api/products/average-by-category")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(inputJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Electronics", is(1500.0)))
                .andExpect(jsonPath("$.Furniture", is(400.0)));
    }
}
