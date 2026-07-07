package com.bank.user_microservice.service;

import com.bank.user_microservice.domain.entity.BankClient;
import com.bank.user_microservice.domain.repositories.BankClientRepository;
import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.response.CreateClientDto;
import com.bank.user_microservice.error.BusinessException;
import com.bank.user_microservice.mapper.BankClientMapper;
import com.bank.user_microservice.service.api.BankClientInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class BankClientService implements BankClientInterface {

    private final BankClientRepository bankClientRepository;
    private final BankClientMapper bankClientMapper;

    @Override
    public CreateClientDto createBankClient(BankClientDto bankClientDto) {
        validateDpi(bankClientDto.getDpi());
        validateClientNotExists(bankClientDto.getDpi());
        validatePhone(bankClientDto.getPhone());

        BankClient bankClient = bankClientMapper.toBankClientEntity(bankClientDto);
        BankClient savedClient = bankClientRepository.saveBankClient(bankClient);

        return bankClientMapper.toCreateClientDto(savedClient);
    }

    private void validateDpi(String dpi) {
        if (Objects.nonNull(dpi) || !dpi.matches("\\d{13}")) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "El DPI debe contener 13 dígitos válidos.");
        }
    }

    private void validateClientNotExists(String dpi) {
        try {
            bankClientRepository.getBankClientByDpi(dpi);
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Un usuario con este DPI ya ha sido registrado.");
        } catch (BusinessException e) {
            if (e.getCode() != HttpStatus.NOT_FOUND) {
                throw e;
            }
        }
    }

    private void validatePhone(String phone) {
        if (Objects.nonNull(phone) || !phone.matches("\\d{8}")) {
            throw new BusinessException(HttpStatus.BAD_REQUEST, "El número telefónico debe contener 8 dígitos.");
        }
    }

}
