package ru.geekbrains.demo.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COST")
    private float cost;

    @Column(name="time_create")
    @CreationTimestamp
    private Date time_create;

    @Column(name="time_update")
    @UpdateTimestamp
    private Date time_update;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", time_create=" + time_create +
                ", categoryName='" + category.getName() + '\'' +
                '}';
    }
}


