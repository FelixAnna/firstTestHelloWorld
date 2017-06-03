package com.xiangyong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by yuxiangyong on 2017/6/3.
 */
@RestController
@RequestMapping("/login/")
public class OAuth2Controller {
    @RequestMapping("/")
    public Principal index(Principal principal) {
        return principal;
    }

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }

    @RequestMapping("/facebook")
    public Principal fb(Principal principal) {
        return principal;
    }

    @RequestMapping("/github")
    public Principal github(Principal principal) {
        return principal;
    }
}
