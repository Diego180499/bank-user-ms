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
@Table(name = "user_session")
public class UserSession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "session_id",length = 255)
    private String sessionId;

    @Column(name = "code_generation_date")
    private LocalDateTime codeGenerationDate;

    @Column(name = "code_expiration_date")
    private LocalDateTime codeExpirationDate;

    @Column(name = "session_generation_date")
    private LocalDateTime sessionGenerationDate;

    @Column(name = "session_expiration_date")
    private LocalDateTime sessionExpirationDate;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private BankUser bankUser;

}
