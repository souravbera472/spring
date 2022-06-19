package com.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApplication {

    @RequestMapping("/get/result")
    public String getHelloWorld(){
        return "hello world";
    }
    @RequestMapping("/get")
    public String getHelloWorld1(){
        return "hello world1";
    }
}
