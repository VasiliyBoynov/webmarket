package ru.geekbrains.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.entities.Product;
import ru.geekbrains.demo.services.ProductService;
import ru.geekbrains.demo.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/app/products

    @GetMapping
    public List<Product> findAllProducts(
            @RequestParam(name = "min_price", defaultValue = "0") Float minPrice,
            @RequestParam(name = "max_price", required = false) Float maxPrice
    ) {
        if (maxPrice == null) {
            maxPrice = Float.MAX_VALUE;
        }
        return productService.findAllByPrice(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.findById(id);
    }
    @PostMapping
    public Product save(@RequestBody Product product) {
        product.setId(null);
        return productService.save(product);
    }

    @DeleteMapping("/{id}")
    public List<Product>  deleteById(@PathVariable Long id) {
        return  productService.deleteById(id);
    }

    @GetMapping("/find/{str}")
    public List<Product>  deleteById(@PathVariable String str) {
        return  productService.findByTitleLike(str);
    }



}
