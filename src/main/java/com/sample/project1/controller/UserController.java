package com.sample.project1.controller;


import com.sample.project1.models.User;
import com.sample.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("user")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<Collection<User>> getUsers() {

        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
    }

    @GetMapping(path="/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {

        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @PutMapping(path="/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user) {

        return new ResponseEntity<>(userService.updateUser(userId, user), HttpStatus.OK);
    }

    @DeleteMapping(path="/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
