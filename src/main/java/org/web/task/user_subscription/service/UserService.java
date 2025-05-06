package org.web.task.user_subscription.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web.task.user_subscription.dto.UserDTO;
import org.web.task.user_subscription.exception.UserNotFoundException;
import org.web.task.user_subscription.mapper.UserMapper;
import org.web.task.user_subscription.model.User;
import org.web.task.user_subscription.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        log.info("Создание нового пользователя с email: {}", userDTO.getEmail());
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public UserDTO getUserById(Long id) {
        log.info("Получение пользователя с ID: {}", id);
        return userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        log.info("Обновление пользователя с ID: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userMapper.updateUserFromDto(userDTO, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        log.info("Удаление пользователя с ID: {}", id);
        userRepository.delete(userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id)));
    }

}
