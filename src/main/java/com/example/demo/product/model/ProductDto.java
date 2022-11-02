package com.example.demo.product.model;

import com.example.demo.product.enums.PrintProducts;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDto {

    private Long id;
    @NotBlank(message = "Укажите тип печатной продукции")
    private PrintProducts printProducts;
    @NotBlank(message = "Имя печатной продукции не может быть пустым")
    private String name;
    private String description;
    @NotBlank(message = "Укажите автора")
    private String author;
    @NotBlank(message = "Укажите издательство")
    private String publishingHouse;
    @PastOrPresent(message = "Указана некорректная дата")
    @NotBlank(message = "Укажите дату публикации")
    private LocalDate publicationDate;
    @NotBlank(message = "Введите общее количество книг")
    private Long quantity;
}
