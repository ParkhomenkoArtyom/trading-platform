package com.task.tradingPlatform.controller;

import com.task.tradingPlatform.service.jwt.JwtService;
import com.task.tradingPlatform.service.userService.UserDetailsServiceImpl;
import com.task.tradingPlatform.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody String email) {
        userDetailsService.loadUserByUsername(email);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, JwtUtil.buildJwtCookie(jwtService.generateToken(email), 1)
                .toString()).body("Пользователь " + email + " успешно вошел в систему");
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, JwtUtil.buildJwtCookie("", 0)
                .toString()).body("Пользователь " + SecurityContextHolder.getContext().getAuthentication().getName() + " вышел из системы");
    }
}
