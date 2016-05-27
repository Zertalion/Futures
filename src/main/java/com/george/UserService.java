package com.george;

import com.george.dao.UsersDAO;
import com.george.model.CurrentUser;
import com.george.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by georg_000 on 5/18/2016.
 */
@Service
public class UserService implements UserDetailsService {
    private UsersDAO usersDAO;

    @Autowired
    public UserService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public CurrentUser loadUserByUsername(String name) throws UsernameNotFoundException {
        Users users = usersDAO.findByName(name);
        return new CurrentUser(users);
    }
}