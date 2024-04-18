package com.pruebatecnica.neorisapi.infra.outputport;

import com.pruebatecnica.neorisapi.domain.PriceModel;

import java.sql.Timestamp;
import java.util.List;

public interface EntityRespository {

    public <T> T findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(
            String applicationDate, Integer productId, Integer brandId);

}
