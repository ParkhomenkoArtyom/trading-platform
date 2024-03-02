package com.task.tradingPlatform.service.sales;

import com.task.tradingPlatform.model.Sale;

import java.math.BigDecimal;

public interface SalesService {
    BigDecimal processSale(Sale saleRequestDto);

    void deleteSalesByDate(String date);
}
