package com.finserv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HealthCheck {
    final String HEALTH_CHECK_MESSAGE = "Server is running!";

    @RequestMapping(value = "health-check", method = RequestMethod.GET)
    @ResponseBody
    public String healthCheck() {
        return HEALTH_CHECK_MESSAGE;
    }

}
