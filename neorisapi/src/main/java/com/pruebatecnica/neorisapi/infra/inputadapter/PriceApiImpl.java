package com.pruebatecnica.neorisapi.infra.inputadapter;

import com.pruebatecnica.neorisapi.PriceCheckingApiDelegate;
import com.pruebatecnica.neorisapi.model.PriceResponse;
import com.pruebatecnica.neorisapi.infra.inputport.PriceInputPort;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.text.ParseException;

import static com.pruebatecnica.neorisapi.util.PriceResponseMapper.convertToPriceResponse;

@Component
@AllArgsConstructor
public class PriceApiImpl implements PriceCheckingApiDelegate {

    @Autowired
    PriceInputPort priceInputPort;

    @Override
    public ResponseEntity<PriceResponse> listPrice(String applicationDate,
                                                   Integer productId,
                                                   Integer chainId) {
        return ResponseEntity.ok()
                .body(convertToPriceResponse(priceInputPort
                        .getPriceCalculate(applicationDate, productId, chainId)));
    }

}
