package com.example.demo.product.service;

import com.example.demo.product.model.ProductDto;
import com.example.demo.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.demo.product.mapper.ProductMapper.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    @Override
    public ProductDto save(ProductDto productDto) {
        return toProductDto(productRepository.save(toProduct(productDto)));
    }

    @Override
    public ProductDto findById(Long id) {
        return toProductDto(productRepository.findById(id)
//                TODO(Переопределить исключение)
                .orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public List<ProductDto> findAll(String sort) {
        return null;
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        ProductDto oldProductDto = findById(id);

        if(productDto.getName() != null) {
            oldProductDto.setName(productDto.getName());
        }
        if (productDto.getPrintProducts() != null) {
            oldProductDto.setPrintProducts(productDto.getPrintProducts());
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
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
