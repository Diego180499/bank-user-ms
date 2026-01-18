package com.bank.user_microservice.dto.response;


import lombok.*;

@Getter
@Setter
@Builder
public class ResponseSuccessfullyDto {

    private int statusCode;

    private String message;

    private Object responseObject;


}
