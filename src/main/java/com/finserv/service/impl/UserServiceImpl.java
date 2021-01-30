package com.finserv.service.impl;

import java.util.List;

import com.finserv.dao.UserDao;
import com.finserv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.finserv.model.User;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

}