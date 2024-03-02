package com.task.tradingPlatform.service.userService;

import com.task.tradingPlatform.exception.DeleteYourAccountException;
import com.task.tradingPlatform.exception.UserNotExistException;
import com.task.tradingPlatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void deleteUserByEmail(String email) {
        if (isUserExist(email)) {
            userRepository.deleteByEmail(email);
            if (Objects.equals(SecurityContextHolder.getContext().getAuthentication().getName(), email)) {
                throw new DeleteYourAccountException("Вы удалили свой аккаунт и вышли из системы");
            }
        }
    }

    private Boolean isUserExist(String email) {
        userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotExistException("Пользователя c email: " + email + " не существует")
        );
        return true;
    }
}
