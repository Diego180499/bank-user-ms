package com.bank.user_microservice.service;

import com.bank.user_microservice.dto.ResponseSuccessDto;
import com.bank.user_microservice.service.api.HealthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HealthServiceImpl implements HealthService {


    @Override
    public ResponseSuccessDto health() {
        return ResponseSuccessDto
                .builder()
                .code(HttpStatus.OK.toString())
                .message("!Endpoint success!")
                .build();
    }
}
