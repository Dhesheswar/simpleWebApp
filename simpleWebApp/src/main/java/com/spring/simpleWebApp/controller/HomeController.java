package com.spring.simpleWebApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(){
        return "Welcome to my new Webpage";
    }

    @RequestMapping("/about")
    public String about(){
        return "This webpage is created in Mac m2";
    }

}
