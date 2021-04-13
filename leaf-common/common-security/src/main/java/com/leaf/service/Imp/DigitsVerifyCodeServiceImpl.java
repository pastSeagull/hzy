package com.leaf.service.Imp;


import com.leaf.exception.VerifyFailedException;
import com.leaf.repository.VerifyCodeRepository;
import com.leaf.service.GenerateImageService;
import com.leaf.service.VerifyCodeService;
import com.leaf.util.VerifyCodeUtil;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.security.SecureRandom;
import java.util.Objects;


/**
 * @author Pu Zhiwei {@literal puzhiweipuzhiwei@foxmail.com}
 * create          2019-11-26 17:07
 * 验证码服务
 */
@Service
public class DigitsVerifyCodeServiceImpl implements VerifyCodeService {
    private final VerifyCodeRepository verifyCodeRepository;

    private final GenerateImageService generateImageService;


    private final VerifyCodeUtil verifyCodeUtil;

    private static final long VERIFY_CODE_EXPIRE_TIMEOUT = 60000L;

    public DigitsVerifyCodeServiceImpl(VerifyCodeRepository verifyCodeRepository, GenerateImageService generateImageService, VerifyCodeUtil verifyCodeUtil) {
        this.verifyCodeRepository = verifyCodeRepository;
        this.generateImageService = generateImageService;
        this.verifyCodeUtil = verifyCodeUtil;
    }

    private static String randomDigitString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    private static String appendTimestamp(String string) {
        return string + "#" + System.currentTimeMillis();
    }

    @Override
    public void send(String key) {
        String verifyCode = randomDigitString(verifyCodeUtil.getLen());
        String verifyCodeWithTimestamp = appendTimestamp(verifyCode);
        verifyCodeRepository.save(key, verifyCodeWithTimestamp);
    }

    @Override
    public void verify(String key, String code) {
        String lastVerifyCodeWithTimestamp = verifyCodeRepository.find(key);
        // 如果没有验证码，则随机生成一个
        if (lastVerifyCodeWithTimestamp == null) {
            lastVerifyCodeWithTimestamp = appendTimestamp(randomDigitString(verifyCodeUtil.getLen()));
        }
        String[] lastVerifyCodeAndTimestamp = lastVerifyCodeWithTimestamp.split("#");
        String lastVerifyCode = lastVerifyCodeAndTimestamp[0];
        long timestamp = Long.parseLong(lastVerifyCodeAndTimestamp[1]);
        if (timestamp + VERIFY_CODE_EXPIRE_TIMEOUT < System.currentTimeMillis()) {
            throw new VerifyFailedException("验证码已过期！");
        } else if (!Objects.equals(code, lastVerifyCode)) {
            throw new VerifyFailedException("验证码错误！");
        }
    }

    @Override
    public Image image(String key) {
        String verifyCode = randomDigitString(verifyCodeUtil.getLen());
        String verifyCodeWithTimestamp = appendTimestamp(verifyCode);
        Image image = generateImageService.imageWithDisturb(verifyCode);
        verifyCodeRepository.save(key, verifyCodeWithTimestamp);
        return image;
    }
}
