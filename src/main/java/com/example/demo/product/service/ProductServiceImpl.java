package com.example.demo.product.service;

import com.example.demo.exception.BookProductException;
import com.example.demo.exception.StorageException;
import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.enums.SortLibrary;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.demo.product.mapper.ProductMapper.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    @CachePut(cacheNames = "productCache", key = "#productDtoId")
    public ProductDto save(ProductDto productDto) {
        return toProductDto(productRepository.save(toProduct(productDto)));
    }

    @Override
    @Cacheable(cacheNames = "productCache", key = "#productDtoId")
    public ProductDto findById(Long id) {
        return toProductDto(productRepository.findById(id)
                .orElseThrow(() -> new StorageException("Объект не найден")));
    }

    @Override
    public List<ProductDto> findAll(SortLibrary sort) {
        switch (sort) {
            case NAME:
                return productRepository.findAll().stream()
                        .map(product -> toProductDto(product))
                        .collect(Collectors.toList());

            case AUTHOR:
                return productRepository.findAllOrderByAuthorAndName().stream()
                        .map(product -> toProductDto(product))
                        .collect(Collectors.toList());

            case QUANTITY:
                return productRepository.findAllOrderByQuantityAndName().stream()
                        .map(product -> toProductDto(product))
                        .collect(Collectors.toList());

            case PUBLICATION_DATE:
                return productRepository.findAllOrderByPublicationDateAndName().stream()
                        .map(product -> toProductDto(product))
                        .collect(Collectors.toList());

            case PUBLISHING_HOUSE:
                return productRepository.findAllOrderByPublishingHouseAndName().stream()
                        .map(product -> toProductDto(product))
                        .collect(Collectors.toList());
            default:
                throw new BookProductException("Некорректно указан тип печатной продукции");
        }
    }

    @Override
    public List<ProductDto> search(String text) {
        if(!text.isBlank()) {
            return productRepository.searchByNameOrderByName(text).stream()
                    .map(product -> toProductDto(product))
                    .collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    @Override
    @CachePut(cacheNames = "productCache", key = "#productDtoId")
    public ProductDto update(Long id, ProductDto productDto) {
        ProductDto oldProductDto = findById(id);

        if(productDto.getName() != null) {
            oldProductDto.setName(productDto.getName());
        }
        if (productDto.getPrintProduct() != null) {
            if(printProductValidation(productDto.getPrintProduct())) {
                oldProductDto.setPrintProduct(productDto.getPrintProduct());
            } else {
                throw new BookProductException("Некорректно указан тип печатной продукции");
            }
        }
        if (productDto.getAuthor() != null) {
            oldProductDto.setAuthor(productDto.getAuthor());
        }
        if (productDto.getDescription() != null) {
            oldProductDto.setDescription(productDto.getDescription());
        }
        if (productDto.getPublicationDate() != null) {
            oldProductDto.setPublicationDate(productDto.getPublicationDate());
        }
        if (productDto.getPublishingHouse() != null) {
            oldProductDto.setPublishingHouse(productDto.getPublishingHouse());
        }
        if (productDto.getQuantity() != null) {
            oldProductDto.setQuantity(productDto.getQuantity());
        }
        return toProductDto(productRepository.save(toProduct(oldProductDto)));
    }

    @Override
    @CacheEvict(cacheNames = "productCache", key = "#productDtoId")
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    // Метод создан для примера работы с Map
    public List<ProductDto> findProductsByType(PrintProduct printProduct) {
        if(!printProductValidation(printProduct)) {
            throw new BookProductException("Некорректно указан тип печатной продукции");
        }
        Map<PrintProduct, List<ProductDto>> allProducts = new HashMap<>();
        for(PrintProduct product : PrintProduct.values()) {
            List<ProductDto> listOfProduct = productRepository.findAllByPrintProductOrderByName(product)
                    .stream()
                    .map((prod) -> toProductDto(prod))
                    .collect(Collectors.toList());
            allProducts.put(product, listOfProduct);
        }
        return allProducts.get(printProduct);
    }

    private boolean printProductValidation(PrintProduct checkProduct) {
        for (PrintProduct product: PrintProduct.values()) {
            if(checkProduct.equals(product)) {
                return true;
            }
        }
        return false;
    }
}
