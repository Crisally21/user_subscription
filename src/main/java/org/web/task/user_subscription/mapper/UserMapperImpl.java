package org.web.task.user_subscription.mapper;

import org.springframework.stereotype.Component;
import org.web.task.user_subscription.dto.UserDTO;
import org.web.task.user_subscription.model.User;

@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        return user;
    }

    @Override
    public void updateUserFromDto(UserDTO userDTO, User user) {
        if (userDTO == null || user == null) {
            return;
        }

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
    }
}