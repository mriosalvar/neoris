package com.pruebatecnica.neorisapi.repository;

import com.pruebatecnica.neorisapi.model.PriceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceModel, Integer> {

    @Query("SELECT p FROM PRICES p " +
            "WHERE p.productId = :productId " +
            "AND p.brandId = :brandId " +
            "AND p.startDate <= :applicationDate " +
            "AND p.endDate >= :applicationDate " +
            "ORDER BY p.priority DESC")
    List<PriceModel> findPriceByApplicationDateAndProductIdAndBrandIdOrderByPriorityDesc(
            Timestamp applicationDate, Integer productId, Integer brandId);

}
