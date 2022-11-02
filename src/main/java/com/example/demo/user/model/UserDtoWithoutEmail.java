package com.example.demo.user.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoWithoutEmail {

    private Long id;
    @NotBlank(message = "Имя не может быть пустым")
    private String name;
}
