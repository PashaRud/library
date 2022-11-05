package com.example.demo.product.repository;

import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(" select p from Product p " +
            "order by p.author, p.name")
    List<Product> findAllOrderByAuthorAndName();

    @Query("select p from Product p " +
            "order by p.publicationDate, p.name")
    List<Product> findAllOrderByPublicationDateAndName();

    @Query("select p from Product p " +
            "order by p.publishingHouse, p.name")
    List<Product> findAllOrderByPublishingHouseAndName();

    @Query("select p from Product p " +
            "order by p.quantity, p.name")
    List<Product> findAllOrderByQuantityAndName();

    List<Product> searchByNameOrderByName(String name);

    List<Product> findAllByPrintProductOrderByName(PrintProduct printProduct);
}
