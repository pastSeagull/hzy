package com.leaf.service;

import java.awt.*;

/**
 * @author hzy
 * create
 * 验证码验证接口
 */
public interface VerifyCodeService {

    void send(String key);

    void verify(String key, String code);

    Image image(String key);
}
