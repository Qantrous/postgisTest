package com.example.postgistest.User.services;

import com.example.postgistest.User.entities.MyUser;
import com.example.postgistest.User.payload.UserCreationRequest;
import com.example.postgistest.User.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;



    @Override
    public MyUser createUser(String name, String username, Long age) {
        MyUser result = new MyUser();
        result.setAge(age);
        result.setName(name);
        result.setUsername(username);
        result.setId(1L);
        userRepo.saveAndFlush(result);

        return result;
    }

    @Override
    public MyUser createUser(UserCreationRequest userCreationRequest) {
        MyUser result = new MyUser();
        result.setAge(userCreationRequest.getAge());
        result.setName(userCreationRequest.getName());
        result.setUsername(userCreationRequest.getUsername());
        userRepo.saveAndFlush(result);

        return result;
    }

    @Override
    public MyUser getUser(Long id) {
        MyUser user = userRepo.getOne(id);
        System.out.println(user.getName().length());
        System.out.println(user.getUsername().length());
        return user;
    }
}
