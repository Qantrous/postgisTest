package com.example.postgistest;


import com.example.postgistest.User.MyUser;
import com.example.postgistest.User.UserCreationRequest;
import com.example.postgistest.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String greet() {
        return "Hello World, its working!";
    }



    @PostMapping("/create/")
    public String created(@Valid @RequestBody UserCreationRequest userCreationRequest) {
        MyUser created = userService.createUser(userCreationRequest);

        return created.toString();
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable("userId") Long userId) {
        return userService.getUser(userId).toString();
    }
}
