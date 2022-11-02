package com.example.demo.user.mapper;

import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
       return new UserDto(user.getId(),
               user.getName(),
               user.getEmail());
    }

    public static User toUser(UserDto userDto) {
        return new User(userDto.getId(),
                userDto.getName(),
                userDto.getEmail());
    }
}
