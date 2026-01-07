package com.bank.user_microservice.repository.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "login_code")
public class LoginCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login_code")
    private String loginCode;

    @Column(name = "code_generation_date")
    private LocalDateTime codeGenerationDate;

    @Column(name = "code_expiration_date")
    private LocalDateTime codeExpirationDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private BankUser bankUser;

}
