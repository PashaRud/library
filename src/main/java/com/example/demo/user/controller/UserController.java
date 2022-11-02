package com.example.demo.user.controller;

import com.example.demo.user.model.UserDto;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserDto save(@Valid @RequestBody UserDto userDto) {
        log.info("Post Запрос к эндпоинту: /users. Данные пользователя: {}",
                userDto.toString());
        return userService.save(userDto);
    }

    @GetMapping
    public List<UserDto> findAll() {
        log.info("Get запрос к эндпоинту: /users. Метод: findAll");
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserDto findById(@PathVariable Long id) {
        log.info("Get запрос к эндпоинту: /users/id. UserId = {}", id);
        return userService.findById(id);
    }

    @PatchMapping("/{id")
    public UserDto update(@PathVariable Long id,
                          @RequestBody UserDto userDto) {
//        TODO(Сделать проверку полей, т.к. для обновления модели может передаваться только одно поле объекта)
        log.info("Patch запрос к эндпоинту: /users/id. Обновленные данные пользователя: {}",
                userDto.toString());
        return userService.update(id, userDto);
    }

    @DeleteMapping("id")
    public void deleteById(@PathVariable Long id) {
        log.info("Delete запрос к эндпоинту: /users/id. UserId = {}", id);
        userService.deleteById(id);
    }
}
