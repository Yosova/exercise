package com.gft.es.prices.application.service.impl;

import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.infrastructure.mapper.PriceMapper;
import com.gft.es.prices.infrastructure.controller.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import com.gft.es.prices.application.repository.PriceRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;


    public PriceServiceImpl(PriceRepository priceRepository, PriceMapper priceMapper) {
        this.priceRepository = priceRepository;

        this.priceMapper = priceMapper;
    }

    @Override
    public PricesOut filter(FilterIn filterIn) throws NotFoundException {

        return priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(filterIn.getProductId(), filterIn.getBrandId(), filterIn.getApplicationDate(),  filterIn.getApplicationDate())
                .stream()
                .findFirst()
                .map(priceMapper::toPriceOut).orElseThrow(NotFoundException::new);
    }
}
