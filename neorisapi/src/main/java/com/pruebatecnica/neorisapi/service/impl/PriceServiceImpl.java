package com.pruebatecnica.neorisapi.service.impl;

import com.pruebatecnica.neorisapi.model.PriceModel;
import com.pruebatecnica.neorisapi.model.PriceResponse;
import com.pruebatecnica.neorisapi.repository.PriceRepository;
import com.pruebatecnica.neorisapi.service.IPriceService;
import com.pruebatecnica.neorisapi.util.DateValidator;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.NoSuchElementException;

@Service
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;

    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public PriceResponse returnAppliedPrice(String applicationDate, Integer productId, Integer brandId) throws ParseException {
        return priceRepository
                .findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(DateValidator
                                .parseTimestamp(applicationDate),
                        productId,
                        brandId)
                .stream()
                .findFirst()
                .map(priceModel -> PriceResponse
                        .builder()
                        .price(priceModel.getPrice())
                        .priceList(priceModel.getPriceList())
                        .endDate(priceModel.getEndDate().toString())
                        .brandId(priceModel.getBrandId())
                        .startDate(priceModel.getStartDate().toString())
                        .productIdentifier(priceModel.getProductId().toString())
                        .build())
                .orElseThrow(() -> new NoSuchElementException("No se encontró ningún precio aplicado para la fecha de aplicación: "
                        + applicationDate + ", productId: " + productId + ", brandId: " + brandId));
    }
}
