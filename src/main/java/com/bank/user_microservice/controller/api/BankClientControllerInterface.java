package com.bank.user_microservice.controller.api;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.CreateClientDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/client")
public interface BankClientControllerInterface {

    @PostMapping("")
    ResponseEntity<CreateClientDto> createClient(
            @RequestHeader("api_key") String apiKey,
            @RequestBody BankClientDto bankClientDto);

}
