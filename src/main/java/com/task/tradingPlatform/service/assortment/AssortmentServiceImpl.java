package com.task.tradingPlatform.service.assortment;

import com.task.tradingPlatform.entity.Pack;
import com.task.tradingPlatform.entity.UnitId;
import com.task.tradingPlatform.model.Assortment;
import com.task.tradingPlatform.service.pack.PackService;
import com.task.tradingPlatform.service.unitIdService.UnitIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AssortmentServiceImpl implements AssortmentService {

    private final PackService packService;
    private final UnitIdService unitIdService;

    public List<Assortment> getAssortmentList() {
        List<Pack> packList = packService.getPacksList();
        List<Integer> unitIds = packList.stream().map(Pack::getUnitId).toList();
        List<UnitId> unitIdList = unitIdService.getUnitIdsByUnitIds(unitIds);
        return packList.stream()
                .map(pack -> new Assortment(
                        pack.getExbarc().getExbarBody(),
                        pack.getPackName(),
                        pack.getPackQuant(),
                        pack.getPackType(),
                        pack.getPackPrc().getPackPrice(),
                        pack.getPackPrc().getPackBonus(),
                        unitIdList.stream()
                                .filter(unitId -> Objects.equals(unitId.getUnitId(), pack.getUnitId()))
                                .findFirst().orElseThrow(null)
                                .getUnitName())
                ).toList();
    }
}
