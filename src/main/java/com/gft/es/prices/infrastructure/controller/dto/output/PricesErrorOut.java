package com.gft.es.prices.infrastructure.controller.dto.output;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@Builder
@Getter
@Setter
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class PricesErrorOut {


    private Integer code;

    private String message;

}
