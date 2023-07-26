package com.gft.es.prices.infrastructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonNaming(value = PropertyNamingStrategies.LowerCamelCaseStrategy.class)
public class FilterIn {

    @NotNull
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime applicationDate;
    @NotNull
    @Min(value = 1, message = "value can not less than 1")
    private Integer brandId;
    @NotNull
    @Min(value = 1, message = "value can not less than 1")
    private Integer productId;

}
