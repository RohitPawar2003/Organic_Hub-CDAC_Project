package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.cdac.modelmvc.Product;
import com.cdac.repository.ProductsRepository;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private ProductsRepository productRepository;

    @PreAuthorize("hasRole('SHOPKEEPER')")
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
