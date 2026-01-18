package com.bank.user_microservice.controller.api;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.ResponseSuccessfullyDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bank-client")
public interface BankClientControllerApi {


    @PostMapping()
    ResponseSuccessfullyDto createBankClient(@RequestBody BankClientDto bankClientDto);


}
