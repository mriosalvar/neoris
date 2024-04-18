package com.pruebatecnica.neorisapi.infra.inputport;

import com.pruebatecnica.neorisapi.domain.PriceModel;

import java.sql.Timestamp;
import java.util.List;

public interface PriceInputPort {

    public PriceModel getPriceCalculate(String applicationDate, Integer productId, Integer brandId);

}
