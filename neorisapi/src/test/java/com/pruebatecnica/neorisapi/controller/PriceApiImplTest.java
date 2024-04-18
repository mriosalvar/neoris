package com.pruebatecnica.neorisapi.controller;

import com.pruebatecnica.neorisapi.domain.PriceModel;
import com.pruebatecnica.neorisapi.model.PriceResponse;
import com.pruebatecnica.neorisapi.infra.inputadapter.PriceApiImpl;
import com.pruebatecnica.neorisapi.infra.inputport.PriceInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceApiImplTest {

    @Mock
    private PriceInputPort priceInputPort;

    @InjectMocks
    private PriceApiImpl priceApi;

    @Test
    public void testListPrice10() throws ParseException {

        String applicationDate = "2020-06-14 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;
        when(priceInputPort.getPriceCalculate(any(), any(), any())).thenReturn(buildPriceResponseForTest());

        ResponseEntity<PriceResponse> response = priceApi.listPrice(applicationDate, productId, brandId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("35455", response.getBody().getProductIdentifier());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals(4, response.getBody().getPriceList());
        assertEquals("2020-06-14 00:00:00.0", response.getBody().getStartDate());
        assertEquals("2020-12-31 23:59:00.0", response.getBody().getEndDate());
        assertEquals(BigDecimal.valueOf(35.50), response.getBody().getPrice());
    }

    private PriceModel buildPriceResponseForTest() {
        return PriceModel.builder()
                .productId(35455)
                .brandId(1)
                .priceList(4)
                .startDate(Timestamp.valueOf("2020-06-14 00:00:00"))
                .endDate(Timestamp.valueOf("2020-12-31 23:59:00"))
                .price(BigDecimal.valueOf(35.50))
                .build();
    }
}