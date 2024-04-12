package com.pruebatecnica.neorisapi.service;

import com.pruebatecnica.neorisapi.model.PriceModel;
import com.pruebatecnica.neorisapi.model.PriceResponse;

import java.text.ParseException;

public interface IPriceService {
    PriceResponse returnAppliedPrice(String applicationDate, Integer productId, Integer brandId) throws ParseException;

}
