package com.task.tradingPlatform.service.userService;

import com.task.tradingPlatform.exception.UserNotExistException;
import com.task.tradingPlatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UserNotExistException("Пользователя c email: " + email + " не существует"));
    }
}