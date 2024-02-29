package com.task.tradingPlatform.service.unitIdService;

import com.task.tradingPlatform.entity.UnitId;
import com.task.tradingPlatform.repository.UnitIdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitIdServiceImpl implements UnitIdService{

    private final UnitIdRepository unitIdRepository;

    @Override
    public UnitId getUnitIdByUnitId(Integer unitId) {
        return unitIdRepository.findByUnitId(unitId).orElseThrow();
    }

    @Override
    public List<UnitId> getUnitIdsByUnitIds(List<Integer> ids) {
        return unitIdRepository.findByUnitIds(ids).orElseThrow();
    }
}
