package com.task.tradingPlatform.service.pack;

import com.task.tradingPlatform.entity.Pack;

import java.math.BigDecimal;
import java.util.List;

public interface PackService {
    List<Pack> getPacksList();

    Pack getPackByExbarBody(String exbarBody);

    Boolean isPackQuantityValid(Boolean packType, BigDecimal quantity);
}
