package com.example.demo.product.model;

import com.example.demo.product.enums.PrintProduct;
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
    private PrintProduct printProduct;
    @NotBlank(message = "Имя печатной продукции не может быть пустым")
    private String name;
    @NotBlank(message = "Добавьте описание продукта")
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
