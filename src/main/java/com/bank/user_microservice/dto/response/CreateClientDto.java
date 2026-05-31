package com.bank.user_microservice.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateClientDto {

    private String dpi;

    private String name;

    @JsonProperty("last_name")
    private String lastName;

}
