package com.bank.user_microservice.service;


import com.bank.user_microservice.dto.request.BankClientDto;
import com.bank.user_microservice.dto.request.BankUserDto;
import com.bank.user_microservice.error.BusinessException;
import com.bank.user_microservice.mapper.BankClientMapper;
import com.bank.user_microservice.repository.entity.BankClient;
import com.bank.user_microservice.repository.entity.BankUser;
import com.bank.user_microservice.repository.repositories.BankClientRepository;
import com.bank.user_microservice.repository.repositories.BankUserRepository;
import com.bank.user_microservice.utils.PasswordUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Service
public class BankUserService {

    private final PasswordUtils passwordUtils;

    private final BankClientRepository bankClientRepository;
    private final BankClientMapper bankClientMapper;
    private final BankUserRepository bankUserRepository;


    public void createAccount(BankUserDto bankUserDto){
        BankUser bankUser = new BankUser();
        BankClientDto bankClientDto = bankClientRepository.getBankClietByDpi(bankUserDto.getBankUserDpi());
        BankClient bankClient = bankClientMapper.toBankClientEntity(bankClientDto);
        bankUser.setId(bankUserDto.getUserId());
        bankUser.setBankClient(bankClient);
        bankUser.setPasswordHash(passwordUtils.encryptPassword(bankUserDto.getPassword()));
        bankUser.setTwoFA(Boolean.FALSE);
        bankUserRepository.createBankUser(bankUser);
    }


}
