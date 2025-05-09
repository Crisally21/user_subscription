package org.web.task.user_subscription.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.web.task.user_subscription.dto.UserDTO;
import org.web.task.user_subscription.model.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subscriptions", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "subscriptions", ignore = true)
    void updateUserFromDto(UserDTO userDTO, @MappingTarget User user);
}
