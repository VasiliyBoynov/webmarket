package ru.geekbrains.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.geekbrains.demo.model.dtos.ProductDto;
import ru.geekbrains.demo.model.entities.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
/*
    List<Product> findByCostGreaterThanEqual(float cost);

    List<Product> findByCostGreaterThanEqualAndCostLessThanEqual(float costMin, float costMax);

    List<Product> findByCostLessThanEqual(float cost);

    List<Product> findByTitleLike(String title);

    List<ProductDto> findAllByCostBetween(float costMin, float costMax);

 */
    }

