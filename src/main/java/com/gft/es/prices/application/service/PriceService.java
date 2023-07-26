package com.gft.es.prices.application.service;

import com.gft.es.prices.domain.Price;
import com.gft.es.prices.infrastructure.rest.dto.FilterIn;
import org.springframework.data.crossstore.ChangeSetPersister;


public interface PriceService {
    Price filter(FilterIn filterIn) throws ChangeSetPersister.NotFoundException;
}
