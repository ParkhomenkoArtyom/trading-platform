package com.task.tradingPlatform.repository;

import com.task.tradingPlatform.entity.Sales;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;


public interface SalesRepository extends JpaRepository<Sales, Integer> {
    @Transactional
    @Modifying
    @Query( " DELETE FROM Sales s " +
            " WHERE s.salesTime BETWEEN :date1 " +
            " AND :date2")
    void deleteSalesByDateWithSecondInterval(@Param("date1") Calendar date1, @Param("date2") Calendar date2);
}
