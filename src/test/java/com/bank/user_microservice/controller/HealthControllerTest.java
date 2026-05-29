package com.bank.user_microservice.controller;

import com.bank.user_microservice.dto.ResponseSuccessDto;
import com.bank.user_microservice.service.api.HealthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HealthControllerTest {

    @Mock
    private HealthService healthService;

    @InjectMocks
    private HealthController healthController;

    @Test
    void health_shouldDelegateToHealthService() {
        ResponseSuccessDto expected = ResponseSuccessDto.builder()
                .code(HttpStatus.OK.toString())
                .message("!Endpoint success!")
                .build();

        when(healthService.health()).thenReturn(expected);

        ResponseSuccessDto response = healthController.health();

        assertNotNull(response);
        assertEquals(expected.getCode(), response.getCode());
        assertEquals(expected.getMessage(), response.getMessage());
        verify(healthService).health();
    }
}
