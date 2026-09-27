package com.spring.simpleWebApp.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String greet(HttpServletRequest request){
        return "Welcome to my new Webpage : "+ request.getSession().getId();
    }

    @RequestMapping("/about")
    public String about(){
        return "This webpage is created in Mac m2";
    }

}
