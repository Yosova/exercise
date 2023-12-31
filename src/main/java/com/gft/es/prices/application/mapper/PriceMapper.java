package com.gft.es.prices.application.mapper;


import com.gft.es.prices.domain.Price;
import com.gft.es.prices.infrastructure.springdata.dbo.PriceModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PriceMapper {

    Price toPrice(PriceModel in);
}
