package com.leaf.service.login.Imp;

import com.leaf.details.LoginResultDetails;
import com.leaf.details.ResultDetails;
import com.leaf.entity.User;
import com.leaf.service.login.LoginService;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author
 * create          2019-12-02 18:51
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public LoginResultDetails get() {
        ResultDetails resultDetails = new ResultDetails();
        resultDetails.setSuccess(false);
        resultDetails.setStatus(HttpStatus.OK.value());
        resultDetails.setMessage("登陆成功！");
        resultDetails.setTimestamp(LocalDateTime.now());
        User user = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Claims claims = (Claims) authentication.getDetails();
        user.setUsername(authentication.getName());
        user.setExpirationTime(claims.getExpiration().getTime());
        user.setPower(claims.get("authorities").toString());
        LoginResultDetails loginResultDetails = new LoginResultDetails();
        loginResultDetails.setUser(user);
        loginResultDetails.setResultDetails(resultDetails);
        loginResultDetails.setStatus(200);
        return loginResultDetails;
    }
}
