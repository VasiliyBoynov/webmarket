package ru.geekbrains.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.entities.Product;
import ru.geekbrains.demo.services.ProductService;


import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    // GET http://localhost:8189/product
    @GetMapping
    public List<Product> getAllStudents() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getStudentById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody Product student) {
        return productService.save(student);
    }
    // GET http://localhost:8189/product/delete/
    @GetMapping("/delete/{id}")
    public List<Product>  deleteById(@PathVariable Long id) {
        return  productService.deleteById(id);
    }

    @GetMapping("/find/{str}")
    public List<Product>  deleteById(@PathVariable String str) {
        return  productService.findByTitleLike(str);
    }



}
