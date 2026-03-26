package com.bank.user_microservice.controller.api;


import com.bank.user_microservice.dto.request.BankUserDto;
import com.bank.user_microservice.dto.response.ResponseSuccessfullyDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bank-user")
public interface BankUserControllerApi {


    @PostMapping
    public ResponseEntity<ResponseSuccessfullyDto> createUserAccount(@RequestBody BankUserDto bankUserDto);

}
