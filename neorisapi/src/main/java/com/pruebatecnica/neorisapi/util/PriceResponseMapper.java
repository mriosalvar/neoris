package com.pruebatecnica.neorisapi.util;

import com.pruebatecnica.neorisapi.domain.PriceModel;
import com.pruebatecnica.neorisapi.model.PriceResponse;

public class PriceResponseMapper {

    public static PriceResponse convertToPriceResponse(PriceModel priceModel) {
        return PriceResponse
                .builder()
                .price(priceModel.getPrice())
                .priceList(priceModel.getPriceList())
                .endDate(priceModel.getEndDate().toString())
                .brandId(priceModel.getBrandId())
                .startDate(priceModel.getStartDate().toString())
                .productIdentifier(priceModel.getProductId().toString())
                .build();
    }

}
