package com.gft.es.prices.application.mapper;


import com.gft.es.prices.infrastructure.springdata.dbo.PriceModel;
import com.gft.es.prices.infrastructure.rest.dto.output.PricesOut;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper {

    PricesOut toPriceOut(PriceModel in);
}
