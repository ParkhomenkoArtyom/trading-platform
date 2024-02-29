package com.task.tradingPlatform.service.userService;

import com.task.tradingPlatform.exception.UserNotExistException;
import com.task.tradingPlatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public Boolean isUserExist(String email) {
        userRepository.findByEmail(email).orElseThrow(
                () -> new UserNotExistException("Пользователя c email: " + email + " не существует")
        );
        return true;
    }
}
