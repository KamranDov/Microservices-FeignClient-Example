package com.crocusoft.userservice.controller;

import com.crocusoft.userservice.domain.User;
import com.crocusoft.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{identityNumber}")
    public ResponseEntity<User> getUserAndDetail(@PathVariable("identityNumber") String identityNumber){
        return new ResponseEntity<>(userService.getUserAndDetail(identityNumber),HttpStatus.OK);
    }
}
