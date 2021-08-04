package ru.geekbrains.demo.model.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name="time_create")
    private Date time_create;

    @Column(name="time_update")
    private Date time_update;

    @Column(name="time_delete")
    private Date time_delete;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;





}
