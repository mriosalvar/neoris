package com.pruebatecnica.neorisapi.controller;

import com.pruebatecnica.neorisapi.PriceCheckingApiDelegate;
import com.pruebatecnica.neorisapi.model.PriceModel;
import com.pruebatecnica.neorisapi.model.PriceResponse;
import com.pruebatecnica.neorisapi.service.impl.PriceServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
@AllArgsConstructor
public class PriceApiImpl implements PriceCheckingApiDelegate {

    private final PriceServiceImpl priceService;

    @Override
    public ResponseEntity<PriceResponse> listPrice(String applicationDate,
                                                   Integer productId,
                                                   Integer chainId) {
        try {
            return ResponseEntity.ok()
                    .body(priceService
                            .returnAppliedPrice(applicationDate, productId, chainId));
        } catch (ParseException e) {
           return ResponseEntity
                   .status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .header("message", e.getMessage())
                   .build();
        }
    }

}
