package org.web.task.user_subscription.mapper;

import org.web.task.user_subscription.dto.SubscriptionDTO;
import org.web.task.user_subscription.model.Subscription;

public interface SubscriptionMapper {
    SubscriptionDTO toDto(Subscription subscription);
    Subscription toEntity(SubscriptionDTO subscriptionDTO);
}