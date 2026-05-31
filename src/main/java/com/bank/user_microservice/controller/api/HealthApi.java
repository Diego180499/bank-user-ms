package com.bank.user_microservice.controller.api;


import com.bank.user_microservice.dto.ResponseSuccessDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
public interface HealthApi {

    @GetMapping("/health")
    public ResponseSuccessDto health();

}
