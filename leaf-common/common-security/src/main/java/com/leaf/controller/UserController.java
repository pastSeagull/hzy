package com.leaf.controller;

import com.leaf.details.LoginResultDetails;
import com.leaf.service.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author Pu Zhiwei {@literal puzhiweipuzhiwei@foxmail.com}
 * create          2019-11-30 17:16
 */
@RestController
@RequestMapping("/api/user")
public class UserController {


    private final LoginService loginService;

    @Autowired
    public UserController( LoginService loginService) {

        this.loginService = loginService;
    }

    @GetMapping("/loginJudge")
    public LoginResultDetails showPage() {
        return loginService.get();
    }

}
