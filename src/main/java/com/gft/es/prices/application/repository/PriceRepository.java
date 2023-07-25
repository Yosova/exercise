package com.gft.es.prices.application.repository;


import com.gft.es.prices.domain.PriceModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface PriceRepository extends CrudRepository<PriceModel, Long> {

  Optional<PriceModel> findFirstByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(Integer productId, Integer brandId, LocalDateTime applicationDate, LocalDateTime applicationDate2);
}
