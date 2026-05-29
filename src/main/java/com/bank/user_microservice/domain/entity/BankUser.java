package com.bank.user_microservice.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bank_user")
public class BankUser {


    @Id
    private String id;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "2_fa")
    private Boolean twoFA;

    @OneToOne
    @JoinColumn(name = "client_dpi",referencedColumnName = "dpi")
    private BankClient bankClient;



}
