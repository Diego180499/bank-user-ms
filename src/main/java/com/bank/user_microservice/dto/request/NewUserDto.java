package com.bank.user_microservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewUserDto {

    @JsonProperty("client_dpi")
    private String clientDpi;

    private String password;

    @JsonProperty("confirm_password")
    private String confirmPassword;

}
