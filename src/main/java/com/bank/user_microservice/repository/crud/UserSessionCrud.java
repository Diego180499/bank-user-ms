package com.bank.user_microservice.repository.crud;

import com.bank.user_microservice.repository.entity.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionCrud extends JpaRepository<UserSession, Integer> {
}
