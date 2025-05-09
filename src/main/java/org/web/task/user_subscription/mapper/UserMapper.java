package org.web.task.user_subscription.mapper;

import org.web.task.user_subscription.dto.UserDTO;
import org.web.task.user_subscription.model.User;

public interface UserMapper {
    UserDTO toDto(User user);
    User toEntity(UserDTO userDTO);
    void updateUserFromDto(UserDTO userDTO, User user);
}