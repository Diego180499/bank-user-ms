package com.bank.user_microservice.repository.crud;

import com.bank.user_microservice.repository.entity.BankUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankUserCrud extends JpaRepository<BankUser, String> {
}
