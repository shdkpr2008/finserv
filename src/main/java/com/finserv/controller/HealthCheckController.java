package com.finserv.controller;

import com.finserv.component.HealthCheckProperty;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@ComponentScan(basePackageClasses = HealthCheckProperty.class)
@PropertySource("classpath:/health-check.properties")
@Controller
public class HealthCheckController {


    @RequestMapping(value = "health-check", method = RequestMethod.GET)
    @ResponseBody
    public String getHealthCheckMessage() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(HealthCheckController.class);
        HealthCheckProperty healthCheckProperty = context.getBean(HealthCheckProperty.class);
        return healthCheckProperty.getHealthCheckMessage();
    }

}
