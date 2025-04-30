package com.raj.breezely.controllers;

import com.raj.breezely.entity.Users;
import com.raj.breezely.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Users> createUser(@RequestBody Users users) {
        return
                userService.create(users) ? new ResponseEntity<>(HttpStatus.CREATED)
                        : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
