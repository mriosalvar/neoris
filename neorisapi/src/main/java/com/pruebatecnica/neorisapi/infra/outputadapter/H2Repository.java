package com.pruebatecnica.neorisapi.infra.outputadapter;

import com.pruebatecnica.neorisapi.domain.PriceModel;
import com.pruebatecnica.neorisapi.infra.outputport.EntityRespository;
import com.pruebatecnica.neorisapi.util.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import java.text.ParseException;

@Component
public class H2Repository implements EntityRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public <T> T findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(String applicationDate,
                                                                                     Integer productId,
                                                                                     Integer brandId) {

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM PRICES p ")
                .append("WHERE p.PRODUCT_ID = :productId ")
                .append("AND p.BRAND_ID = :brandId ")
                .append("AND p.START_DATE <= :startDate ")
                .append("AND p.END_DATE >= :startDate ")
                .append("ORDER BY p.PRIORITY DESC ")
                .append("LIMIT 1");

        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("productId", productId)
                .addValue("brandId", brandId)
                .addValue("startDate", applicationDate);

        return (T) namedParameterJdbcTemplate.queryForObject(sql.toString(), namedParameters,
                BeanPropertyRowMapper.newInstance(PriceModel.class));

    }
}
