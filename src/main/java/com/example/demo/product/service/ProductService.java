package com.example.demo.product.service;

import com.example.demo.product.model.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll(String sort);

    ProductDto update(Long id, ProductDto productDto);

    void delete(Long id);
}
