package com.task.tradingPlatform.utils;

import ch.qos.logback.core.util.Duration;
import org.springframework.http.ResponseCookie;

public class JwtUtil {
    public static ResponseCookie buildJwtCookie(String jwtValue, Integer cookieDurationInDays) {
        return ResponseCookie.from("jwt", jwtValue).path("/")
                .maxAge(Duration.buildByDays(cookieDurationInDays).getMilliseconds()).build();
    }
}
