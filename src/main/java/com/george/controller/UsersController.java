package com.george.controller;


import com.george.dao.UsersDAO;
import com.george.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersDAO usersDAO;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Users findById(@PathVariable String name) {
        return usersDAO.findByName(name);
    }

    @RequestMapping(value = "/hash", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Users users) {
         usersDAO.setHash(users);
    }
}
