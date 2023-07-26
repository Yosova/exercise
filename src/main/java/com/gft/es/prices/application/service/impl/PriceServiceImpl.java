package com.gft.es.prices.application.service.impl;

import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.application.mapper.PriceMapper;
import com.gft.es.prices.domain.Price;
import com.gft.es.prices.infrastructure.rest.dto.FilterIn;
import com.gft.es.prices.infrastructure.springdata.repository.PriceRepository;
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
    public Price filter(FilterIn filterIn) throws NotFoundException {
        if(ObjectUtils.isEmpty(filterIn) || ObjectUtils.isEmpty(filterIn.getProductId())
                || ObjectUtils.isEmpty(filterIn.getBrandId()) || ObjectUtils.isEmpty(filterIn.getBrandId())){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, filterIn.toString());
        }
        return priceRepository.findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(filterIn.getProductId(), filterIn.getBrandId(), filterIn.getApplicationDate(),  filterIn.getApplicationDate())
                .stream()
                .findFirst()
                .map(priceMapper::toPrice).orElseThrow(NotFoundException::new);
    }
}
