package com.finserv.service;

import com.finserv.model.User;

import java.util.List;

public interface UserService {
    public User getUser(int id);

    public List<User> getUsers();

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int id);

}
