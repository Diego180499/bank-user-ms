package com.bank.user_microservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewClientDto {

    private String dpi;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

    private String phone;

    private String email;

}
