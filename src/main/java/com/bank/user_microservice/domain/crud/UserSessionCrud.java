package com.bank.user_microservice.domain.crud;

import com.bank.user_microservice.domain.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionCrud extends JpaRepository<UserSession, Integer> {
}
