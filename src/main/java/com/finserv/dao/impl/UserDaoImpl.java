package com.finserv.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.finserv.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.transaction.annotation.Transactional;

import com.finserv.model.User;
import com.finserv.rowmapper.UserRowMapper;

public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public User getUser(int id) {
        User user = (User) jdbcTemplate.queryForObject("select * from user where id = ?  and is_active=TRUE",
                new Object[]{id}, new UserRowMapper());
        return user;
    }

    @Transactional
    public List<User> getUsers() {
        List<User> users = (List<User>) jdbcTemplate.query("select * from user where is_active=TRUE",
                new UserRowMapper());
        return users;
    }

    @Transactional
    public int addUser(User user) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        simpleJdbcInsert.withTableName("user").usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(4);
        parameters.put("first_name", user.getFirstName());
        parameters.put("last_name", user.getLastName());
        Number insertedId = simpleJdbcInsert.executeAndReturnKey(parameters);
        return insertedId.intValue();
    }

    @Transactional
    public int updateUser(User user) {
        String sql = "update user set first_name = ?, last_name = ? where id = ? and  is_active=TRUE";
        int resp = jdbcTemplate.update(sql, new Object[]{user.getFirstName(), user.getLastName(), user.getId()});
        return resp;
    }

    @Transactional
    public int deleteUser(int id) {
        String sql = "update user set is_active=FALSE where id = ? and is_active=TRUE";
        int resp = jdbcTemplate.update(sql, new Object[]{id});
        return resp;
    }
}