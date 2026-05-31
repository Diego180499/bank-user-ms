package com.bank.user_microservice.service;

import com.bank.user_microservice.dto.ResponseSuccessDto;
import com.bank.user_microservice.service.api.HealthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class HealthServiceTest {

    private HealthService healthService;

    @BeforeEach
    void setUp() {
        healthService = new HealthServiceImpl();
    }

    @Test
    void health_shouldReturnSuccessResponse() {
        ResponseSuccessDto response = healthService.health();

        assertNotNull(response);
        assertEquals(HttpStatus.OK.toString(), response.getCode());
        assertEquals("!Endpoint success!", response.getMessage());
        assertNull(response.getData());
    }
}
