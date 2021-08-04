package ru.geekbrains.demo.services;



import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.demo.exceptions.ResourceNotFoundException;
import ru.geekbrains.demo.model.dtos.ProductDto;
import ru.geekbrains.demo.model.entities.Product;
import ru.geekbrains.demo.repositories.ProductRepository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Component
@Setter
@Getter
@RequiredArgsConstructor
@SessionScope
public class ShopingCartService {
    private Map<ProductDto,Integer> map;
    private final ProductService productService;

    @PostConstruct
    public void init(){
        map = new HashMap<>();
    }


    public void addProductById(Long id) throws RuntimeException{
        ProductDto product = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " doesn't exist"));

        if (map.containsKey(product)){
            map.put(product, map.get(product)+1);
        } else {
            map.put(product,1);
        }
    }

    public void deleteProduct(ProductDto product) {
        if (map.containsKey(product)){
            if (map.get(product)<=1) {
                map.remove(product);
            } else {
                map.put(product, map.get(product)-1);
            }
        }
    }

    public void deleteAllProduct(){
        if(!map.isEmpty()){
            map.clear();
        }
    }

    public Map<ProductDto,Integer> findAll(){
        return map;
    }




}
