package com.bank.user_microservice.service;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.ResponseSuccessfullyDto;
import com.bank.user_microservice.mapper.BankClientMapper;
import com.bank.user_microservice.repository.entity.BankClient;
import com.bank.user_microservice.repository.repositories.BankClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BankClientService {

    private final BankClientRepository bankClientRepository;

    private final BankClientMapper bankClientMapper;


    public ResponseSuccessfullyDto createBankClient(BankClientDto bankClientDto){
        BankClient bankClient = bankClientMapper.toBankClientEntity(bankClientDto);
        bankClient = bankClientRepository.saveBankClient(bankClient);
        BankClientDto bankClientDtoSaved = bankClientMapper.toDto(bankClient);
        return ResponseSuccessfullyDto.builder().statusCode(HttpStatus.CREATED.value()).message("Cliente registrado correctamente").responseObject(bankClientDtoSaved).build();
    }


    public BankClientDto getByDpi(String dpi){
        return bankClientRepository.getBankClietByDpi(dpi);
    }

    public void createAccount(){
        
    }

    public List<BankClientDto> getAllBankClient(){
        return bankClientRepository.getAllBankClientDto();
    }


}
