package com.bank.user_microservice.controller;

import com.bank.user_microservice.controller.api.BankClientControllerInterface;
import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.CreateClientDto;
import com.bank.user_microservice.service.api.BankClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BankClientController implements BankClientControllerInterface {

    private final BankClientInterface bankClientInterface;

    @Override
    public ResponseEntity<CreateClientDto> createClient(String apiKey, BankClientDto bankClientDto) {
        CreateClientDto createClientDto = bankClientInterface.createBankClient(bankClientDto);
        return new ResponseEntity<>(createClientDto, HttpStatus.OK);
    }

}
