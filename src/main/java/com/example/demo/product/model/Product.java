package com.example.demo.product.model;

import com.example.demo.product.enums.PrintProduct;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "print_product")
    private PrintProduct printProduct;
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
    @Column(name = "quantity")
    private Long quantity;
}
