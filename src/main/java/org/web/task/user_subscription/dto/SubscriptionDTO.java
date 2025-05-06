package org.web.task.user_subscription.dto;

import lombok.Data;

@Data
public class SubscriptionDTO {
    private String serviceName;
    private String plan;
    private Double price;
}
