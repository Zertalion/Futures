package com.george.dao;

import com.george.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UsersDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Users findByName(String name){
        return jdbcTemplate.queryForObject("SELECT name, password FROM Users WHERE name=?" ,
                new Object[]{name},
                new UsersRowMapper());
    }

    public void setHash(Users user){
        jdbcTemplate.update("UPDATE Users SET password = ?  WHERE name = ?" , new BCryptPasswordEncoder().encode(user.getPassword()), user.getName());
    }

    private static class UsersRowMapper implements RowMapper<Users> {
        @Override
        public Users mapRow(ResultSet rs, int i) throws SQLException {
            return Users.builder()

                    .name(rs.getString("name"))
                    .password(rs.getString("password"))

                    .build();
        }
    }
}
