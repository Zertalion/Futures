package com.george.dao;

import com.george.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesDAO extends ADAO<Sales> {

    @Autowired
    public SalesDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Sales> findAll() {
        return jdbcTemplate.query("SELECT id, firstName, lastName,department, dateOfBirth FROM Sales",
                new SalesRowMapper());
    }

    @Override
    public Sales findById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, firstName, lastName,department, dateOfBirth FROM Sales where id=?",
                new Object[]{id},
                new SalesRowMapper());
    }

    @Override
    public int insert(Sales obj) {
        return jdbcTemplate.update("INSERT INTO sales (id,lastName,firstName,dateOfBirth,department) VALUES (?,?,?,?,?)",
                obj.getId(), obj.getLastName(), obj.getFirstName(), obj.getDateOfBirth(), obj.getDepartment());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Sales where id = ?", id);
    }

    @Override
    public int update(Sales obj) {
        return jdbcTemplate.update("UPDATE sales SET dateOfBirth = ?, department = ? where id = ? ", obj.getDateOfBirth(), obj.getDepartment(), obj.getId());
    }

    public Sales findSalesByFirstAndLastName(String firstName, String lastName) {
        return (Sales) jdbcTemplate.queryForObject("SELECT id, FirstName, LastName,department, dateOfBirth " +
                        "FROM Sales where firstName = ? and lastName = ? ",
                new Object[]{firstName, lastName},
                new SalesRowMapper());
    }



    private static class SalesRowMapper implements RowMapper<Sales> {
        @Override
        public Sales mapRow(ResultSet rs, int i) throws SQLException {
            return Sales.builder()
                    .id(rs.getInt("id"))
                    .lastName(rs.getString("lastName"))
                    .firstName(rs.getString("firstName"))
                    .dateOfBirth(rs.getDate("dateOfBirth"))
                    .department(rs.getString("department"))
                    .build();
        }
    }
}

