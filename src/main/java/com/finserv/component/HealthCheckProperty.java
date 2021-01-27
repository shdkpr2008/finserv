package com.finserv.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class HealthCheckProperty implements HealthCheckPropertyInterface {

    @Value("${healthCheck.message:no-message-set}")
    String HEALTH_CHECK_MESSAGE;

    public String getHealthCheckMessage() {
        return HEALTH_CHECK_MESSAGE;
    }

}
