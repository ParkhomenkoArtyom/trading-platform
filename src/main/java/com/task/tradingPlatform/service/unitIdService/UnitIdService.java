package com.task.tradingPlatform.service.unitIdService;

import com.task.tradingPlatform.entity.UnitId;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface UnitIdService {
    UnitId getUnitIdByUnitId(Integer unitId);
    List<UnitId> getUnitIdsByUnitIds(List<Integer> ids);
}
