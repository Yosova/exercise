package com.gft.es.prices.infrastructure.rest.mapper;


import com.gft.es.prices.domain.Price;
import com.gft.es.prices.infrastructure.rest.dto.PriceOut;
import com.gft.es.prices.infrastructure.springdata.dbo.PriceModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ControllerMapper {

    PriceOut fromPrice(Price in);
}
