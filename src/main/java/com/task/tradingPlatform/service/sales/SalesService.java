package com.task.tradingPlatform.service.sales;

import com.task.tradingPlatform.model.Sale;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public interface SalesService {
    BigDecimal processSale(Sale saleRequestDto);

    void deleteSalesByDate(Calendar date);
}
