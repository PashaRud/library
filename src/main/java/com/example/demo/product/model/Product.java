package com.example.demo.product.model;

import com.example.demo.product.enums.PrintProducts;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Enumerated(EnumType.STRING)
    private PrintProducts printProducts;
    @Column(name = "product_id")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "author")
    private String author;
    @Column(name = "publishing_house")
    private String publishingHouse;
    @Column(name = "publication_date")
    private LocalDate publicationDate;
    @Column(name = "count")
    private Long quantity;
}
