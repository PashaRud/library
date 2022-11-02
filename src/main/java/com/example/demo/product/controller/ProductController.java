package com.example.demo.product.controller;

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
    public List<ProductDto> findAll(@RequestParam(defaultValue = "name") String sort) {
        log.info("Get запрос к эндпоинту: /products. Метод: findAll с сортировкой по {}", sort);
        return productService.findAll(sort);
    }

    @PutMapping("id")
    public ProductDto update(@RequestBody ProductDto productDto,
                             @PathVariable Long id) {
//        TODO(Сделать проверку полей, т.к. для обновления модели может передаваться только одно поле объекта)
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
