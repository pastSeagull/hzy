package com.leaf.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码异常信息
 * 继承 AuthenticationException 方便 Spring security 返回异常
 */
public class VerifyFailedException extends AuthenticationException {

    public VerifyFailedException(String msg) {
        super(msg);
    }
}