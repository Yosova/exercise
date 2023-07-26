package com.gft.es.prices.infrastructure.rest.dto.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class PricesOut {


    private Integer brandId;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    private LocalDateTime startDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH.mm.ss")
    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Double price;

}
