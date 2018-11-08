package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = "/get")
    @ResponseBody
    public String getInfo(String token) {
        return "hello world";
    }

}
