package com.bank.user_microservice.error;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class ErrorDto {

    private HttpStatus code;

    private String message;

}
