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
    @PutMapping(value = "/update-user/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody MyUser updatedUser) {
        Optional<MyUser> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            optionalUser.ifPresent(user -> {
                user.setFirstname(updatedUser.getFirstname());
                user.setLastname(updatedUser.getLastname());
                user.setEmail(updatedUser.getEmail());
                userService.saveUser(user);
            });
            return ResponseEntity.ok().build();
        } else
            return ResponseEntity.badRequest().build();
    }
    @DeleteMapping(value="/delete-user/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
