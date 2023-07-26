package com.gft.es.prices.application.service;

import com.gft.es.prices.infrastructure.rest.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.rest.dto.output.PricesOut;
import org.springframework.data.crossstore.ChangeSetPersister;


public interface PriceService {
    PricesOut filter(FilterIn filterIn) throws ChangeSetPersister.NotFoundException;
}
