package com.bank.user_microservice.domain.repositories;


import com.bank.user_microservice.error.BusinessException;
import com.bank.user_microservice.domain.crud.BankUserCrud;
import com.bank.user_microservice.domain.entity.BankUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;


@Slf4j
@RequiredArgsConstructor
@Repository
public class BankUserRepository {

    private final BankUserCrud bankUserCrud;

    public void createBankUser(BankUser bankUser){
        if(bankUserCrud.findById(bankUser.getId()).isPresent()){
            throw new BusinessException(HttpStatus.BAD_REQUEST, "Este nombre de usuario no está disponible");
        }

        bankUserCrud.save(bankUser);
    }


}
