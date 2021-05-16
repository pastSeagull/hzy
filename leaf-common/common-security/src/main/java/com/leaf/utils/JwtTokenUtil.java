package com.leaf.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: night
 * @Desc: jwt工具类
 */
@Component
@Data
public class JwtTokenUtil {
    // 令牌自定义标识
    @Value("${night.jwt.header}")
    private String Header;
    //JWT密钥
    @Value("${night.jwt.secret}")
    private String secret;
    //JWT有效时间
    @Value("${night.jwt.expireDate}")
    private Long expireDate;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;
//    @Autowired
//    private RedisCache redisCache;
    /**
     * 生成token令牌
     *
     * @param userDetails 用户
     * @param payloads    令牌中携带的附加信息
     * @return 令token牌
     */
    public String generateToken(UserDetails userDetails,
                                Map<String, String> payloads) {
        int payloadSizes = payloads == null ? 0 : payloads.size();

        Map<String, Object> claims = new HashMap<>(payloadSizes + 2);
        claims.put("sub", userDetails.getUsername());
        claims.put("created", new Date());

        if (payloadSizes > 0) {
            for (Map.Entry<String, String> entry : payloads.entrySet()) {
                claims.put(entry.getKey(), entry.getValue());
            }
        }

        return generateToken(claims);
    }
    /**
     * 生成token令牌
     *
     * @param token 用户
     * @param payloads    令牌中携带的附加信息
     * @return 令token牌
     */
    public String generateToken(String token,
                                Map<String, String> payloads) {
        int payloadSizes = payloads == null ? 0 : payloads.size();

        Map<String, Object> claims = new HashMap<>(payloadSizes + 2);
        claims.put("sub", token);
        claims.put("created", new Date());

        if (payloadSizes > 0) {
            for (Map.Entry<String, String> entry : payloads.entrySet()) {
                claims.put(entry.getKey(), entry.getValue());
            }
        }

        return generateToken(claims);
    }
    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token       令牌
     * @param userDetails 用户
     * @return 是否有效
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


    /**
     * 从claims生成令牌,如果看不懂就看谁调用它
     *
     * @param claims 数据声明
     * @return 令牌
     */
    private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 从令牌中获取数据声明,如果看不懂就看谁调用它
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    public static void main(String[] args) {
        JwtTokenUtil jwtTokenUtil =new JwtTokenUtil();
        Map<String,Object> map =new HashMap<>();
        map.put("name","huag");
        System.out.println(jwtTokenUtil.generateToken(map));
    }
}
