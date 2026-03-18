package com.example.skill8.controller;

import com.example.skill8.entity.Product;
import com.example.skill8.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/category/{category}")
    public List<Product> getCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> getRange(@RequestParam double min,
                                 @RequestParam double max) {
        return service.getByRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSorted();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensive(price);
    }
}