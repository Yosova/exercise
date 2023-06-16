package com.gft.es.prices.application.service;

import com.gft.es.prices.infrastructure.controller.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import java.util.Optional;


public interface PriceService {
    Optional<PricesOut> filter(FilterIn filterIn);
}
