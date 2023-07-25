package com.gft.es.prices.infrastructure.controller;

import com.gft.es.prices.application.service.PriceService;
import com.gft.es.prices.infrastructure.controller.dto.input.FilterIn;
import com.gft.es.prices.infrastructure.controller.dto.output.PricesOut;
import jakarta.validation.Valid;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Validated
@RestController
@RequestMapping("/api/prices")
public class PriceController {


  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }



  @PostMapping("")
  public ResponseEntity<PricesOut> status(@Valid @RequestBody FilterIn statusIn) throws Exception{

    return ResponseEntity.ok(priceService.filter(statusIn));
  }

}
