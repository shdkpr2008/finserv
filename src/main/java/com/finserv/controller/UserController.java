package com.finserv.controller;

import com.finserv.exception.UserNotFoundException;
import com.finserv.model.User;
import com.finserv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getUsers() {
        List<User> users = userService.getUsers();
        String usersJson = "{ \"users\": [";
        for (User user : users) {
            usersJson += user.toJson();
        }
        usersJson += "] }";
        return usersJson;
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String getUsers(@PathVariable Integer userId) {
        try {
            User user = userService.getUser(userId);
            return user.toJson();
        } catch (Exception e) {
            throw new UserNotFoundException(userId);
        }
    }

    @RequestMapping(value = "users/{userId}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public String deleteUsers(@PathVariable Integer userId) {
        try {
            userService.deleteUser(userId);
            return "";
        } catch (Exception e) {
            throw new UserNotFoundException(userId);
        }
    }

}

