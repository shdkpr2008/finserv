package com.finserv.controller;

import com.finserv.component.HealthCheckProperty;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HealthCheckController.class, HealthCheckProperty.class})
@TestPropertySource("classpath:/health-check-test.properties")
public class HealthCheckControllerMessageTest {

    @Autowired
    private HealthCheckController healthCheckController;

    @Autowired
    private HealthCheckProperty healthCheckProperty;

    @Test
    public void testHealthCheckMessage() throws Exception {
        assertEquals(healthCheckController.getHealthCheckMessage(),
                healthCheckProperty.getHealthCheckMessage());
    }

}
