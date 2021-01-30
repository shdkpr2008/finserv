package com.finserv.exception;

public class UserNotFoundException extends NotFoundException {
    public UserNotFoundException(int id) {
        super("user " + id + " not found");
    }
}
