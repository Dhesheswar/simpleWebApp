package com.spring.simpleWebApp.controller;

import com.spring.simpleWebApp.model.Users;
import com.spring.simpleWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public ResponseEntity<Users> createNewUser(@RequestBody Users user){
       return  new ResponseEntity<>(userService.createNewUser(user), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> displayUsers(){
        return new ResponseEntity<>(userService.display(),HttpStatus.OK);
    }
}
