package org.web.task.user_subscription.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web.task.user_subscription.dto.SubscriptionDTO;
import org.web.task.user_subscription.exception.UserNotFoundException;
import org.web.task.user_subscription.mapper.SubscriptionMapper;
import org.web.task.user_subscription.model.Subscription;
import org.web.task.user_subscription.model.User;
import org.web.task.user_subscription.repository.SubscriptionRepository;
import org.web.task.user_subscription.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final SubscriptionMapper subscriptionMapper;

    @Transactional
    public SubscriptionDTO addSubscription(Long userId, SubscriptionDTO subscriptionDTO) {
        log.info("Adding subscription for user ID: {}", userId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Subscription subscription = subscriptionMapper.toEntity(subscriptionDTO);
        subscription.setUser(user);

        Subscription savedSubscription = subscriptionRepository.save(subscription);
        return subscriptionMapper.toDto(savedSubscription);
    }

    public List<SubscriptionDTO> getUserSubscriptions(Long userId) {
        log.info("Fetching subscriptions for user ID: {}", userId);

        if (!userRepository.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }

        return subscriptionRepository.findByUserId(userId).stream()
                .map(subscriptionMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteSubscription(Long userId, Long subscriptionId) {
        log.info("Deleting subscription ID: {} for user ID: {}", subscriptionId, userId);

        Subscription subscription = subscriptionRepository.findByIdAndUserId(subscriptionId, userId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Subscription not found with id: " + subscriptionId + " for user id: " + userId));

        subscriptionRepository.delete(subscription);
    }

    public List<Object[]> getTop3PopularSubscriptions() {
        log.info("Fetching top 3 popular subscriptions");
        return subscriptionRepository.findTop3PopularSubscription();
    }
}