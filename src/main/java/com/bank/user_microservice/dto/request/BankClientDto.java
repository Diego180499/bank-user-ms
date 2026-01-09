package com.bank.user_microservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankClientDto {

    private String dpi;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private String email;

    private String phone;

}
