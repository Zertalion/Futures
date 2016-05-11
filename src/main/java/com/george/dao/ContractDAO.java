package com.george.dao;

import com.george.SpringConfig;

import com.george.model.Contract;
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
public class ContractDAO extends ADAO<Contract> {

    @Autowired
    public ContractDAO(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate);
    }

    @Override
    public List<Contract> findAll() {
        return jdbcTemplate.query("SELECT * FROM Contract",
                new ContractRowMapper());
    }

    @Override
    public Contract findById(int id) {
        return (Contract) jdbcTemplate.queryForObject("SELECT * FROM Contract where id=?",
                new Object[]{id},
                new ContractRowMapper());
    }
    @Override
    public int insert(Contract obj) {
        return jdbcTemplate.update("INSERT INTO Contract (id,ClientID,SalesID,creationDate,settlementDate,usedCurrency,boughtCurrency,exchangeRate,amount,price) VALUES (?,?,?,?,?,?,?,?,?,?)",
                obj.getId(), obj.getClientID(), obj.getSalesID(), obj.getCreationDate(), obj.getSettlementDate(),obj.getUsedCurrency(), obj.getBoughtCurrency(), obj.getExchangeRate(), obj.getAmount(),obj.getPrice());
    }

    @Override
    public int deleteById(int id) {
        return jdbcTemplate.update("delete from Contract where id = ?", id);
    }

    @Override
    public int update(Contract obj) {
        return jdbcTemplate.update("UPDATE Contract SET settlementDate = ?, SalesID = ?, amount=? where id = ? ", obj.getSettlementDate(), obj.getSalesID(),obj.getAmount(), obj.getId());
    }






    private static class ContractRowMapper implements RowMapper {
        @Override
        public Object mapRow(ResultSet rs, int i) throws SQLException {
            return Contract.builder()
                    .id(rs.getInt("id"))
                    .ClientID(rs.getInt("ClientID"))
                    .SalesID(rs.getInt("SalesID"))
                    .creationDate(rs.getDate("creationDate"))
                    .settlementDate(rs.getDate("settlementDate"))
                    .usedCurrency(rs.getString("usedCurrency"))
                    .boughtCurrency(rs.getString("boughtCurrency"))
                    .exchangeRate(rs.getDouble("exchangeRate"))
                    .amount(rs.getInt("amount"))
                    .price(rs.getInt("price"))
                    .build();
        }
    }

}
