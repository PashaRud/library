package com.example.demo.product.productServiceTests;

import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.product.service.ProductService;
import com.example.demo.product.service.ProductServiceImpl;
import org.junit.jupiter.api.BeforeEach;


import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class ProductServiceTest {

    private ProductService productService;
    private ProductRepository productRepository;
    private ProductDto product1;
    private ProductDto product2;
    private ProductDto product3;
    private ProductDto product4;
    private ProductDto product5;
    private ProductDto product6;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);
        productService = new ProductServiceImpl(productRepository);
        product1 = new ProductDto(1L, PrintProduct.BOOK, "1984", "Антиутопия",
                "Джордж Оруэлл","Издательство 1", LocalDate.of(1949, 6, 8),
                100L);
        product2 = new ProductDto(2L, PrintProduct.JOURNAL, "PC Magazine/RE", "Компьютерный журнал",
                "Зифф Дэвис","Издательство 2", LocalDate.of(2022, 10, 1),
                90L);
        product3 = new ProductDto(3L, PrintProduct.NEWSPAPER, "PC Week/RE", "Антиутопия",
                "Васильев Валерий","Издательство 3", LocalDate.of(2022, 9, 1),
                800L);
        product4 = new ProductDto(4L, PrintProduct.GUIDE, "Путеводитель Бедекера", "справочник о Uk",
                "Карл Бедекер","Издательство 3", LocalDate.of(2022, 8, 1),
                700L);
        product5 = new ProductDto(5L, PrintProduct.CATALOG, "Каталог запчастей", "Каталог запчастей",
                "many people","Издательство 3", LocalDate.of(2022, 7, 1),
                600L);
        product6 = new ProductDto(6L, PrintProduct.MAP, "Карта мира", "Физическая карта мира",
                "many people","Издательство 2", LocalDate.of(2022, 6, 1),
                500L);
    }

//    @Test
//    void createItemTest() {
//        when(productService.save(product1))
//                .thenReturn(product1);
//        when(productService.findById(any()))
//                .thenReturn(product1);
//
//        ProductDto productDto = productService.save(product1);
//
//        assertNotNull(productDto);
//        assertEquals("1984", productDto.getName());
//        assertEquals("Антиутопия", productDto.getDescription());
//        assertEquals(product1.getId(), productDto.getId());
//        verify(productRepository, times(1)).save(any());
//    }
}
