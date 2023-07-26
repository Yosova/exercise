package com.gft.es.prices.infrastructure.springdata.dbo;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "PRICES")
public class PriceModel {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "BRAND_ID")
  private Integer brandId;
  @Column(name = "START_DATE")
  private LocalDateTime startDate;
  @Column(name = "END_DATE")
  private LocalDateTime endDate;
  @Column(name = "PRICE_LIST")
  private Integer priceList;
  @Column(name = "PRODUCT_ID")
  private Integer productId;
  @Column(name = "PRIORITY")
  private Integer priority;
  @Column(name = "PRICE")
  private Double price;
  @Column(name = "CURR")
  private String curr;

}
