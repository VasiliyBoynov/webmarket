package ru.geekbrains.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.demo.entities.Product;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCostGreaterThanEqual(float cost);

    List<Product> findByCostGreaterThanEqualAndCostLessThanEqual(float costMin, float costMax);

    List<Product> findByCostLessThanEqual(float cost);

    List<Product> findByTitleLike(String title);

    List<Product> findAllByCostBetween(float costMin, float costMax);
    }

