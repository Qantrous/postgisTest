package com.example.postgistest.User.repository;

import com.example.postgistest.User.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<MyUser, Long> {
}
