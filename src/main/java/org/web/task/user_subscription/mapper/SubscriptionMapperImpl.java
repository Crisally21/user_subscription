package org.web.task.user_subscription.mapper;

import org.springframework.stereotype.Component;
import org.web.task.user_subscription.dto.SubscriptionDTO;
import org.web.task.user_subscription.model.Subscription;

@Component
public class SubscriptionMapperImpl implements SubscriptionMapper {

    @Override
    public SubscriptionDTO toDto(Subscription subscription) {
        if (subscription == null) {
            return null;
        }

        SubscriptionDTO dto = new SubscriptionDTO();
        dto.setServiceName(subscription.getServiceName());
        dto.setPlan(subscription.getPlan());
        dto.setPrice(subscription.getPrice());
        return dto;
    }

    @Override
    public Subscription toEntity(SubscriptionDTO subscriptionDTO) {
        if (subscriptionDTO == null) {
            return null;
        }

        Subscription subscription = new Subscription();
        subscription.setServiceName(subscriptionDTO.getServiceName());
        subscription.setPlan(subscriptionDTO.getPlan());
        subscription.setPrice(subscriptionDTO.getPrice());
        return subscription;
    }
}