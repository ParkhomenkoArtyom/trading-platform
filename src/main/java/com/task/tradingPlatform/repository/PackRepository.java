package com.task.tradingPlatform.repository;

import com.task.tradingPlatform.entity.Pack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PackRepository extends JpaRepository<Pack, Integer> {
    @Query( " SELECT p FROM Pack p" +
            " JOIN FETCH p.exbarc" +
            " JOIN FETCH p.packPrc")
    Optional<List<Pack>> getAllPacks();

    @Query( " SELECT p FROM Pack p " +
            " JOIN FETCH p.exbarc" +
            " JOIN FETCH p.packPrc" +
            " WHERE p.exbarc.exbarBody LIKE :exbarBody")
    Optional<Pack> findByExbarBody(@Param("exbarBody") String exbarBody);
}
