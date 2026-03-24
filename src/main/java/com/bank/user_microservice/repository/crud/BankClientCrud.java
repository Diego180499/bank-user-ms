package com.bank.user_microservice.repository.crud;

import com.bank.user_microservice.repository.entity.BankClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankClientCrud extends JpaRepository<BankClient, String> {



    //Optional<BankClient> getBankClientByUsernameAndPassword();

}
