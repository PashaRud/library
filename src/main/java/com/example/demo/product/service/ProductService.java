package com.example.demo.product.service;

import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.enums.SortLibrary;
import com.example.demo.product.model.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto save(ProductDto productDto);

    ProductDto findById(Long id);

    List<ProductDto> findAll(SortLibrary sort);

    List<ProductDto> findProductsByType(PrintProduct printProduct);

    List<ProductDto> search(String text);

    ProductDto update(Long id, ProductDto productDto);

    void delete(Long id);
}
