package org.web.task.user_subscription.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.web.task.user_subscription.dto.UserDTO;
import org.web.task.user_subscription.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subscriptions", ignore = true)
    User toEntity(UserDTO userDTO);

    @Mapping(target = "subscriptions", ignore = true)
    void updateUserFromDto(UserDTO userDTO, @MappingTarget User user);
}
