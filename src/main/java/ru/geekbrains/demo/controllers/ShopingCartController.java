package ru.geekbrains.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.demo.model.dtos.ProductDto;
import ru.geekbrains.demo.model.entities.Product;
import ru.geekbrains.demo.repositories.ProductRepository;
import ru.geekbrains.demo.repositories.specifications.ProductSpecifications;
import ru.geekbrains.demo.services.ProductService;
import ru.geekbrains.demo.services.ShopingCartService;

import java.util.List;
import java.util.Map;
// GET http://localhost:8189/app/cart
@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class ShopingCartController {
    private final ShopingCartService shopingCartService;
    private final ProductRepository productRepository;

    @GetMapping
    public Map<ProductDto, Integer> findAllProducts(
            @RequestParam(name = "id", required = false) Long id
    ) {
        if (id != null)
         {
            shopingCartService.addProductById(id);
        }
        return shopingCartService.findAll();
    }
/*
    @PostMapping
    public void save(@RequestBody Long id) {
        shopingCartService.addProductById(id);
    }
*/
    @DeleteMapping("/{id}")
    public Map<ProductDto, Integer> deleteById(@PathVariable Long id) {
        shopingCartService.deleteProduct(productRepository.findById(id).map(p -> new ProductDto(p)).orElse(new ProductDto()));
        //return shopingCartService.findAll();
        return findAllProducts(null);
    }
}
