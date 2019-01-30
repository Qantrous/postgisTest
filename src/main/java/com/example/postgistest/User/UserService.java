package com.example.postgistest.User;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    MyUser createUser(String name, String username, Long age);
    MyUser getUser(Long id);

    MyUser createUser(UserCreationRequest userCreationRequest);
}
