package com.example.postgistest.User.entities;

import com.example.postgistest.User.payload.UserDetails;

import javax.persistence.*;

@Entity
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "object_id")
    @SequenceGenerator(sequenceName = "object_id_sequence", allocationSize = 1, name = "object_id")
    private Long id;


    private String name;
    private String username;
    private Long age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public UserDetails toUserDetails() {
        return new UserDetails(this.name, this.age, this.username);
    }

}
