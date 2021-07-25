package ru.geekbrains.demo.services;


import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findById(Long id){
        return productRepository.findById(id).orElse(new Product());
    }

    public Product save(Product product){
        return  productRepository.save(product);
    }

    public List<Product> deleteById(Long id){
        productRepository.deleteById(id);
        return productRepository.findAll();
    }

    public List<Product> moreMin (float cost){
        return productRepository.findByCostGreaterThanEqual(cost);
    }

    public List<Product> findByTitleLike(String str){
        String strTmp = str + "%";
        return productRepository.findByTitleLike(strTmp);
    }













}
