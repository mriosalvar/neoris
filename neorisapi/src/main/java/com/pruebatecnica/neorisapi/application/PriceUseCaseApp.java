package com.pruebatecnica.neorisapi.application;

import com.pruebatecnica.neorisapi.domain.PriceModel;
import com.pruebatecnica.neorisapi.infra.inputport.PriceInputPort;
import com.pruebatecnica.neorisapi.infra.outputport.EntityRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PriceUseCaseApp implements PriceInputPort {

    @Autowired
    EntityRespository entityRespository;

    @Override
    public PriceModel getPriceCalculate(String applicationDate, Integer productId, Integer brandId) {
        return entityRespository
                .findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(applicationDate,
                        productId,
                        brandId);
    }
}
