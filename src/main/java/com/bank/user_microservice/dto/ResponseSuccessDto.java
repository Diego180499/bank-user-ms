package com.bank.user_microservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseSuccessDto {

    private String code;

    private String message;

    private Object data;

}
