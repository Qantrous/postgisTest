package com.example.postgistest.User.services;

import com.example.postgistest.User.entities.MyUser;
import com.example.postgistest.User.payload.UserCreationRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    MyUser createUser(String name, String username, Long age);
    MyUser getUser(Long id);

    MyUser createUser(UserCreationRequest userCreationRequest);
}
