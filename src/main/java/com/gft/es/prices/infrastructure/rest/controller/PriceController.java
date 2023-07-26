package com.gft.es.prices.infrastructure.rest.controller;

import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.infrastructure.rest.dto.FilterIn;
import com.gft.es.prices.infrastructure.rest.dto.PriceOut;
import com.gft.es.prices.infrastructure.rest.mapper.ControllerMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api/prices")
public class PriceController {


  private final PriceService priceService;

  private final ControllerMapper mapper;

  public PriceController(PriceService priceService, ControllerMapper mapper) {
    this.priceService = priceService;
    this.mapper = mapper;
  }



  @PostMapping("")
  public ResponseEntity<PriceOut> status(@Valid @RequestBody FilterIn statusIn) throws Exception{

    return ResponseEntity.ok(mapper.fromPrice(priceService.filter(statusIn)));
  }

}
