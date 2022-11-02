package com.example.demo.user.service;

import com.example.demo.user.model.UserDto;

import java.util.List;

public interface UserService {

    UserDto save (UserDto userDto);

    List<UserDto> findAll();

    UserDto findById(Long userId);

    UserDto update(Long userId, UserDto userDto);

    void deleteById(Long userId);


}
