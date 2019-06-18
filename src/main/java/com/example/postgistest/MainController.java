package com.example.postgistest;


import com.example.postgistest.User.entities.MyUser;
import com.example.postgistest.User.payload.UserCreationRequest;
import com.example.postgistest.User.payload.UserDetails;
import com.example.postgistest.User.services.UserService;
import com.example.postgistest.answer.AnswerRepository;
import com.example.postgistest.answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private AnswerRepository answerRepository;

    @GetMapping
    public String greet() {
        return "Hello World, its working! love you <3 ";
    }



    @PostMapping("/create")
    public String created(@Valid @RequestBody UserCreationRequest userCreationRequest) {
        MyUser created = userService.createUser(userCreationRequest);

        return created.toString();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok().body(userService.getUser(userId).toUserDetails());
    }


    @GetMapping("/loveyou")
    public ResponseEntity<String> getSomeText() {

        return ResponseEntity.ok().body(answerService.getAnswer());
    }

}
