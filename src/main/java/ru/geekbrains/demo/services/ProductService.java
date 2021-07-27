package ru.geekbrains.demo.services;


import lombok.*;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.entities.Product;
import ru.geekbrains.demo.repositories.ProductRepository;

import java.util.List;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Product findById(Long id){
        return productRepository.findById(id).orElse(new Product());
    }

    public List<Product> findAllByPrice(Float min, Float max) {
        return productRepository.findAllByCostBetween(min, max);
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public List<Product> deleteById(Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public List<Product> findByTitleLike(String str){
        String strTmp = str + "%";
        return productRepository.findByTitleLike(strTmp);
    }













}
