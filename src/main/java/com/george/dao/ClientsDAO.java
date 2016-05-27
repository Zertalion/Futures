package com.george.dao;

import com.george.SpringConfig;
import com.george.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class ClientsDAO extends ADAO<Clients> {

    @Autowired
    public ClientsDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Clients> findAll() {
        return jdbcTemplate.query("SELECT id, FirstName, LastName,nationality, age, SalesID FROM Clients",
                new ClientsRowMapper());
    }

    @Override
    public Clients findById(int id) {
        return (Clients) jdbcTemplate.queryForObject("SELECT id, FirstName, LastName,nationality, age, SalesID FROM Clients where id=?",
                new Object[]{id},
                new ClientsRowMapper());
    }
    @Override
    public  int insert(Clients obj) {
        return jdbcTemplate.update("INSERT INTO Clients (lastName,firstName,age,nationality,SalesID) VALUES (?,?,?,?,?)",
                obj.getLastName(), obj.getFirstName(), obj.getAge(), obj.getNationality(),obj.getSalesID());
    }
    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Clients where id = ?", id);
    }

    @Override
    public int update(Clients obj) {
        return jdbcTemplate.update("UPDATE Clients SET age = ?, SalesID = ? where id = ? ", obj.getAge(), obj.getSalesID(), obj.getId());
    }

    public Clients findClientByfirstAndLastName(String firstName, String lastName, String country){
        return (Clients) jdbcTemplate.queryForObject("SELECT id, FirstName, LastName,nationality, age, SalesID " +
                                                     "FROM Clients where firstName=? and lastName=? and nationality=?",
                new Object[]{firstName, lastName, country},
                new ClientsRowMapper());
    }


    private static class ClientsRowMapper implements RowMapper {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                return Clients.builder()
                        .id(rs.getInt("id"))
                        .lastName(rs.getString("lastName"))
                        .firstName(rs.getString("firstName"))
                        .age(rs.getInt("age"))
                        .nationality(rs.getString("nationality"))
                        .SalesID(rs.getInt("SalesID"))
                        .build();
            }
    }
}
