package com.gft.es.prices.infrastructure.handler.exception.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;


@AllArgsConstructor
@Data
public class RestError{

    @NonNull
    private Integer code;
    private String message;
    private String infoURL;

}
