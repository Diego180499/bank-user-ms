package com.bank.user_microservice.service.api;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.CreateClientDto;

public interface BankClientInterface {

    CreateClientDto createBankClient(BankClientDto bankClientDto);

}
