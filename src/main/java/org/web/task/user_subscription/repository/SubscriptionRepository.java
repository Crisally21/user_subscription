package org.web.task.user_subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.web.task.user_subscription.model.Subscription;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    @Query("SELECT s.serviceName, COUNT(s) as count FROM Subscription s GROUP BY s.serviceName ORDER BY count DESC LIMIT 3")
    List<Object[]> findTop3PopularSubscription();

    @Query("SELECT s FROM Subscription s WHERE s.user.id = :userId")
    List<Subscription> findByUserId(@Param("userId") Long userId);

    @Query("SELECT s FROM Subscription s WHERE s.id = :subscriptionId AND s.user.id = :userId")
    Optional<Subscription> findByIdAndUserId(@Param("subscriptionId") Long subscriptionId,
                                             @Param("userId") Long userId);
}
