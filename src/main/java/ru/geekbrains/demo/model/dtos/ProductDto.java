package ru.geekbrains.demo.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.demo.model.entities.Product;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private float cost;
    private Date time_update;
    private String categoryName;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.cost = p.getCost();
        this.time_update = p.getTime_update();
        this.categoryName = p.getCategory().getName();
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
