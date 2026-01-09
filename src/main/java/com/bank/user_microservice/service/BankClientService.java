package com.bank.user_microservice.service;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.repository.entity.BankClient;
import com.bank.user_microservice.repository.repositories.BankClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankClientService {

    private final BankClientRepository bankClientRepository;


    public BankClientDto getBankClient(String dpi){
        return bankClientRepository.getBankClientDto(dpi);
    }

    public List<BankClientDto> getAllBankClient(){
        return bankClientRepository.getAllBankClientDto();
    }


}
