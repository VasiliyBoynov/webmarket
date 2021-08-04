package ru.geekbrains.demo.services;


import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<ProductDto> findAll(Specification<Product> spec, int page, int pageSize) {
        return productRepository.findAll(spec, PageRequest.of(page - 1, pageSize)).map(p -> new ProductDto(p));
    }

    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id).map(p -> new ProductDto(p));
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public List<Product> deleteById(Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }















}
