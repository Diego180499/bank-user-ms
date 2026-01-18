package com.bank.user_microservice.controller;

import com.bank.user_microservice.controller.api.BankClientControllerApi;
import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.ResponseSuccessfullyDto;
import com.bank.user_microservice.service.BankClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class BankClientController implements BankClientControllerApi {

    private final BankClientService bankClientService;

    @Override
    public ResponseSuccessfullyDto createBankClient(BankClientDto bankClientDto) {
        log.info("POST /bank-client  -- create bank client");
        return bankClientService.createBankClient(bankClientDto);
    }
}
