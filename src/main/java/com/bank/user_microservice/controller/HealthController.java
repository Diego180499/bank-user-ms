package com.bank.user_microservice.controller;

import com.bank.user_microservice.controller.api.HealthApi;
import com.bank.user_microservice.dto.ResponseSuccessDto;
import com.bank.user_microservice.service.api.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HealthController implements HealthApi {

    private final HealthService healthService;


    @Override
    public ResponseSuccessDto health() {
        return healthService.health();
    }
}
