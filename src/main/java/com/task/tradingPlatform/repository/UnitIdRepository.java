package com.task.tradingPlatform.repository;

import com.task.tradingPlatform.entity.UnitId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UnitIdRepository extends JpaRepository<UnitId, Integer> {
    Optional<UnitId> findByUnitId(Integer unitId);
    @Query( " SELECT u FROM UnitId u" +
            " WHERE u.unitId IN :unitIds")
    Optional<List<UnitId>> findByUnitIds(@Param("unitIds") List<Integer> unitIds);
}
