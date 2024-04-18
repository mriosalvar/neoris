package com.pruebatecnica.neorisapi.domain;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PriceModel {

    private Integer id;
    private Integer brandId;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private BigDecimal price;
    private String currency;

}
