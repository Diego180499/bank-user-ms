package com.bank.user_microservice.controller;

import com.bank.user_microservice.controller.api.BankUserControllerApi;
import com.bank.user_microservice.dto.request.BankUserDto;
import com.bank.user_microservice.dto.response.ResponseSuccessfullyDto;
import com.bank.user_microservice.service.BankUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class BankUserController implements BankUserControllerApi {

    private final BankUserService bankUserService;

    @Override
    public ResponseEntity<ResponseSuccessfullyDto> createUserAccount(BankUserDto bankUserDto) {
        bankUserService.createAccount(bankUserDto);
        return new ResponseEntity<>(ResponseSuccessfullyDto.builder().statusCode(HttpStatus.CREATED.value()).message("Cuenta de usuario creada").build(), HttpStatus.CREATED);
    }
}
