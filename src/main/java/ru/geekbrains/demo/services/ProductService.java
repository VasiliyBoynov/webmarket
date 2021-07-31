package ru.geekbrains.demo.services;


import lombok.*;
import org.springframework.stereotype.Service;
import ru.geekbrains.demo.exceptions.ResourceNotFoundException;
import ru.geekbrains.demo.model.dtos.ProductDto;
import ru.geekbrains.demo.model.entities.Product;
import ru.geekbrains.demo.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;


    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(p -> new ProductDto(p));
    }

    public List<ProductDto> findAllByPrice(Float min, Float max) {
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
