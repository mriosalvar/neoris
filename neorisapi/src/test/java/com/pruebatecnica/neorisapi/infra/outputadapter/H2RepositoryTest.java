package com.pruebatecnica.neorisapi.infra.outputadapter;

import com.pruebatecnica.neorisapi.domain.PriceModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class H2RepositoryTest {

    @Mock
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @InjectMocks
    private H2Repository h2Repository;

    @Test
    void findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc() {
        String applicationDate = "2022-04-11 10:00:00";
        Integer productId = 35455;
        Integer brandId = 1;
        BeanPropertyRowMapper<PriceModel> mapper = new BeanPropertyRowMapper<>(PriceModel.class);

        var priceModel = PriceModel
                .builder()
                .productId(35455)
                .price(BigDecimal.ONE)
                .id(1)
                .priceList(1)
                .endDate(Timestamp.valueOf(applicationDate))
                .startDate(Timestamp.valueOf(applicationDate))
                .build();

        when(namedParameterJdbcTemplate.queryForObject(anyString(), any(MapSqlParameterSource.class),
                any(BeanPropertyRowMapper.class))).thenReturn(priceModel);

        PriceModel result = h2Repository.findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(
                applicationDate, productId, brandId);

        assertEquals(priceModel, result);

        verify(namedParameterJdbcTemplate).queryForObject(anyString(), any(MapSqlParameterSource.class),
                any(BeanPropertyRowMapper.class));
    }
}