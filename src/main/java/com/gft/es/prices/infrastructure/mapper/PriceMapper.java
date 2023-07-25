package com.gft.es.prices.infrastructure.mapper;


import com.gft.es.prices.domain.PriceModel;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PricesOut toPriceOut(PriceModel in);
}
