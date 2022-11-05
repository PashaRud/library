package com.example.demo.product.controller;

import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.enums.SortLibrary;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ProductDto save(@Valid @RequestBody ProductDto productDto) {
        log.info("Post Запрос к эндпоинту: /products. Данные пользователя: {}",
                productDto.toString());
       return productService.save(productDto);
    }

    @GetMapping("id")
    public ProductDto findById(@PathVariable Long id) {
        log.info("Get запрос к эндпоинту: /products/id. ProductId = {}", id);
        return productService.findById(id);
    }

    @GetMapping
    public List<ProductDto> findAll(@RequestParam(defaultValue = "name") SortLibrary sort) {
        log.info("Get запрос к эндпоинту: /products. Метод: findAll с сортировкой по {}", sort);
        return productService.findAll(sort);
    }

    @GetMapping("by_type")
    public List<ProductDto> findProductsByType(@RequestParam PrintProduct printProduct) {
        log.info("Get запрос к эндпоинту: /products/by_type. " +
                "Метод: findProductsByType с типом печатной продукции - {}", printProduct);
        return productService.findProductsByType(printProduct);
    }

    @GetMapping("/search")
    public List<ProductDto> search(@RequestParam String text) {
        log.info("Get запрос к эндпоинту: /products/search. Метод: search. Текст поиска - {}", text);
        return productService.search(text);
    }

    @PutMapping("id")
    public ProductDto update(@RequestBody ProductDto productDto,
                             @PathVariable Long id) {
        log.info("Patch запрос к эндпоинту: /products/id. Обновленные данные продукта: {}",
                productDto.toString());
        return productService.update(id, productDto);
    }

    @DeleteMapping("id")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete запрос к эндпоинту: /products/id. ProdutId = {}", id );
        productService.delete(id);
    }
}
