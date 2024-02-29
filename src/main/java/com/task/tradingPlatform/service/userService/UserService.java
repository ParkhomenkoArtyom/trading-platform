package com.task.tradingPlatform.service.userService;

public interface UserService {
    void deleteUserByEmail(String email);

    Boolean isUserExist(String email);
}
