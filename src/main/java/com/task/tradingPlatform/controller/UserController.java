package com.task.tradingPlatform.controller;

import com.task.tradingPlatform.service.userService.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @DeleteMapping("/delete/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        if (userService.isUserExist(email))
            userService.deleteUserByEmail(email);
        return ResponseEntity.ok().body("Пользователь c email: " + email + " успешно удален");
    }
}
