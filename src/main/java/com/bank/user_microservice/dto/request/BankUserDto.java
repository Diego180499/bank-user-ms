package com.bank.user_microservice.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class BankUserDto {

     @JsonProperty("user_id")
    private String userId;

    private String password;

     @JsonProperty("bank_user_dpi")
    private String bankUserDpi;

}
