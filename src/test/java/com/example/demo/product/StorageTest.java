package com.example.demo.product;

import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.repository.ProductRepository;
import com.example.demo.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureTestDatabase
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class StorageTest {

    private final ProductService productService;
    private final ProductRepository productRepository;
    private static Product product1;
    private static ProductDto product2;
    private static ProductDto product3;
    private static ProductDto product4;
    private static ProductDto product5;
    private static ProductDto product6;

//    @BeforeAll
//    public static void createProducts() {
//        product1 = new Product(null ,PrintProduct.BOOK, "1984", "Антиутопия",
//                "Джордж Оруэлл","Издательство 1", LocalDate.of(1949, 6, 8),
//                100L);
//        product2 = new ProductDto(null, PrintProduct.JOURNAL, "PC Magazine/RE", "Компьютерный журнал",
//                "Зифф Дэвис","Издательство 2", LocalDate.of(2022, 10, 1),
//                90L);
//        product3 = new ProductDto(null, PrintProduct.NEWSPAPER, "PC Week/RE", "Антиутопия",
//                "Васильев Валерий","Издательство 3", LocalDate.of(2022, 9, 1),
//                800L);
//        product4 = new ProductDto(null, PrintProduct.GUIDE, "Путеводитель Бедекера", "справочник о Uk",
//                "Карл Бедекер","Издательство 3", LocalDate.of(2022, 8, 1),
//                700L);
//        product5 = new ProductDto(null, PrintProduct.CATALOG, "Каталог запчастей", "Каталог запчастей",
//                "many people","Издательство 3", LocalDate.of(2022, 7, 1),
//                600L);
//        product6 = new ProductDto(null, PrintProduct.MAP, "Карта мира", "Физическая карта мира",
//                "many people","Издательство 2", LocalDate.of(2022, 6, 1),
//                500L);
//        }

    @Test
    void saveTest() {
        System.out.println(productRepository.findById(1L).toString());
    }
}
