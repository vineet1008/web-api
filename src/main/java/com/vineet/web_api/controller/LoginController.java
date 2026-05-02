package com.vineet.web_api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/web-api/")
public class LoginController {

    @GetMapping
    public String home(){
        return "Hey This is the Spring boot App";
    }


}
