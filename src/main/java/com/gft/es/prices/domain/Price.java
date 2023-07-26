package com.gft.es.prices.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class Price {

    private Integer brandId;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Integer priceList;

    private Integer productId;

    private Double price;

    private String curr;

    private Integer priority;
}
