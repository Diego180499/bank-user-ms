package com.bank.user_microservice.repository.repositories;

import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.mapper.BankClientMapper;
import com.bank.user_microservice.repository.crud.BankClientCrud;
import com.bank.user_microservice.repository.entity.BankClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Repository
public class BankClientRepository {

    private final BankClientCrud bankClientCrud;

    private final BankClientMapper mapper;

    public BankClientDto getBankClientDto(String dpi){
        Optional<BankClient> bankClient = bankClientCrud.findById(dpi);

        if(bankClient.isEmpty()){
            //todo gestionar excepciones
            log.info("Error en la busqueda del cliente");
            return null;
        }

        return mapper.toDto(bankClient.get());
    }

    public List<BankClientDto> getAllBankClientDto(){
        return mapper.toDto(bankClientCrud.findAll());
    }

}
