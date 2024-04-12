package com.pruebatecnica.neorisapi.service.impl;

import com.pruebatecnica.neorisapi.model.PriceModel;
import com.pruebatecnica.neorisapi.repository.PriceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void returnAppliedPrice() throws ParseException {

        String applicationDate = "2020-06-14 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;

        when(priceRepository
                .findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(any(),
                        any(), any())).thenReturn(List.of(PriceModel
                .builder()
                .productId(35455)
                .brandId(1)
                .priceList(4)
                .startDate(Timestamp.valueOf("2020-06-14 00:00:00"))
                .endDate(Timestamp.valueOf("2020-12-31 23:59:00"))
                .price(BigDecimal.valueOf(35.50))
                .build()));

       var response = priceService.returnAppliedPrice(applicationDate, productId, brandId);
        assertEquals("35455", response.getProductIdentifier());
        assertEquals(1, response.getBrandId());
        assertEquals(4, response.getPriceList());
        assertEquals("2020-06-14 00:00:00.0", response.getStartDate());
        assertEquals("2020-12-31 23:59:00.0", response.getEndDate());
        assertEquals(BigDecimal.valueOf(35.50), response.getPrice());
    }
}