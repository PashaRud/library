package com.example.demo.product.mapper;

import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(product.getId(),
                product.getPrintProduct(),
                product.getName(),
                product.getDescription(),
                product.getAuthor(),
                product.getPublishingHouse(),
                product.getPublicationDate(),
                product.getQuantity());
    }

    public static Product toProduct(ProductDto productDto) {
        return new Product(productDto.getId(),
                productDto.getPrintProduct(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getAuthor(),
                productDto.getPublishingHouse(),
                productDto.getPublicationDate(),
                productDto.getQuantity());
    }
}
