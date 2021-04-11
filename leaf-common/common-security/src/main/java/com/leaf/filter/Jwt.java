package com.leaf.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Jwt {
    private static final String KEY_USERNAME="HZY";
    private static final String KEY_CREATE="HZYY";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;


}
