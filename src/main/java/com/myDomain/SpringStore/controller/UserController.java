package com.myDomain.SpringStore.controller;

import com.myDomain.SpringStore.model.MyUser;
import com.myDomain.SpringStore.repository.UserRepository;
import com.myDomain.SpringStore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addUser( @RequestBody MyUser user) {

            userService.addUser(user);
            return ResponseEntity.ok().build();

    }
}
