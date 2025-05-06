package org.web.task.user_subscription.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.web.task.user_subscription.dto.SubscriptionDTO;
import org.web.task.user_subscription.model.Subscription;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {
    SubscriptionDTO toDto(Subscription subscription);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Subscription toEntity(SubscriptionDTO subscriptionDTO);
}
