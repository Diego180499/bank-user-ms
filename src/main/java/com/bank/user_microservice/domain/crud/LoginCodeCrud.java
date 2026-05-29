package com.bank.user_microservice.domain.crud;

import com.bank.user_microservice.domain.entity.LoginCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginCodeCrud extends JpaRepository<LoginCode, Integer> {
}
