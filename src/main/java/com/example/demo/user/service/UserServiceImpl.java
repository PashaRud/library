package com.example.demo.user.service;

import com.example.demo.user.model.UserDto;
import com.example.demo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.user.mapper.UserMapper.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto save(UserDto userDto) {
        return toUserDto(userRepository.save(toUser(userDto)));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(user -> toUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long userId) {
        return toUserDto(userRepository.findById(userId)
//                TODO(ПЕРЕОПРЕДЕЛИТЬ ИСКЛЮЧЕНИЕ)
                .orElseThrow(() -> new RuntimeException()));
    }

    @Override
    public UserDto update(Long userId, UserDto userDto) {
        UserDto oldUserDto = findById(userId);
        //TODO(Уточнить необходимость проверки имени на null, с учетом аннотации @NotBlank)
        oldUserDto.setName(userDto.getName());
        //Если пользователь захотел убрать свой email -
        // мы получаем обновленный экземпляр пользователя с email = null.
        oldUserDto.setEmail(userDto.getEmail());
        return toUserDto(userRepository.save(toUser(oldUserDto)));
    }

    @Override
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
}
