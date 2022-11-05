package com.example.demo.product.productControllerTests;


import com.example.demo.product.controller.ProductController;
import com.example.demo.product.enums.PrintProduct;
import com.example.demo.product.mapper.ProductMapper;
import com.example.demo.product.model.Product;
import com.example.demo.product.model.ProductDto;
import com.example.demo.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;


import static com.example.demo.product.enums.PrintProduct.BOOK;
import static com.example.demo.product.mapper.ProductMapper.toProductDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;
    ObjectMapper mapper = new ObjectMapper();
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;
    private Product product5;
    private Product product6;

    @BeforeEach
    void setUp() {
        mapper.registerModule(new JavaTimeModule());
        product1 = new Product(1L, BOOK, "1984", "Антиутопия",
                "Джордж Оруэлл","Издательство 1", LocalDate.of(1949, 6, 8),
                100L);
        product2 = new Product(2L, PrintProduct.JOURNAL, "PC Magazine/RE", "Компьютерный журнал",
                "Зифф Дэвис","Издательство 2", LocalDate.of(2022, 10, 1),
                90L);
        product3 = new Product(3L, PrintProduct.NEWSPAPER, "PC Week/RE", "Антиутопия",
                "Васильев Валерий","Издательство 3", LocalDate.of(2022, 9, 1),
                800L);
        product4 = new Product(4L, PrintProduct.GUIDE, "Путеводитель Бедекера", "справочник о Uk",
                "Карл Бедекер","Издательство 3", LocalDate.of(2022, 8, 1),
                700L);
        product5 = new Product(5L, PrintProduct.CATALOG, "Каталог запчастей", "Каталог запчастей",
                "many people","Издательство 3", LocalDate.of(2022, 7, 1),
                600L);
        product6 = new Product(6L, PrintProduct.MAP, "Карта мира", "Физическая карта мира",
                "many people","Издательство 2", LocalDate.of(2022, 6, 1),
                500L);
    }

    @Test
    void createProductTest() throws Exception {
        ProductDto dto = toProductDto(product2);
        when(productService.save(any()))
                .thenReturn(dto);

        mockMvc.perform(post("/products")
                        .content(mapper.writeValueAsString(dto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(dto.getName()));
    }
}
