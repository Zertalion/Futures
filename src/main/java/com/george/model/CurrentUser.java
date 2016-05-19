package com.george.model;


import java.util.Collections;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private Users user;

    public CurrentUser(Users user) {
        super(user.getName(), user.getPassword(), Collections.emptyList());
        this.user = user;
    }

    public Users getUsers() {
        return user;
    }

}
