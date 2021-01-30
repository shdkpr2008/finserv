package com.finserv.dao;

import java.util.List;

import com.finserv.model.User;

public interface UserDao {
    public User getUser(int id);

    public List<User> getUsers();

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);
}