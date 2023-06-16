package com.gft.es.prices.application.service.impl;

import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.application.service.mapper.PriceMapper;
import com.gft.es.prices.infrastructure.controller.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import com.gft.es.prices.infrastructure.repository.PriceRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;


    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;

        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<PricesOut> filter(FilterIn filterIn){
        return priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(filterIn.getProductId(), filterIn.getBrandId(), filterIn.getApplicationDate(),  filterIn.getApplicationDate())
                .stream()
                .findFirst()
                .map(priceMapper::toPriceOut);
    }
}
