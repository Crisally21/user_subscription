package org.web.task.user_subscription.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web.task.user_subscription.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
