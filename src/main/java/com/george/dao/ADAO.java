package com.george.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class ADAO<T> {
    protected final JdbcTemplate jdbcTemplate;

    public ADAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract List<T> findAll();

    public abstract T findById(int id);

    public abstract int insert(T obj);

    public abstract int deleteById(int id);

    public abstract int update(T obj);
}
