package org.web.task.user_subscription.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id) {
        super("Пользователь не найден с id: " + id);
    }
}
