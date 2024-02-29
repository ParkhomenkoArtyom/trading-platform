package com.task.tradingPlatform.controller;

import com.task.tradingPlatform.exception.InvalidDateFormatException;
import com.task.tradingPlatform.model.Sale;
import com.task.tradingPlatform.service.sales.SalesService;
import com.task.tradingPlatform.utils.DateUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.GenericValidator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sale")
public class SalesController {
    private final SalesService salesService;

    @PostMapping
    public ResponseEntity<String> saleProducts(@Valid @RequestBody Sale sale) {
        return ResponseEntity.ok(
                "Операция оплаты прошла успешно, сдача = " + salesService.processSale(sale));
    }

    @DeleteMapping("/delete/{date}")
    public void deleteSalesByDate(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") String date) {
        if(!GenericValidator.isDate(date, "yyyy-MM-dd HH:mm:ss", true))
            throw new InvalidDateFormatException("Не верный формат даты. Шаблон: yyyy-MM-dd HH:mm:ss");
        salesService.deleteSalesByDate(DateUtil.getDateFromString(date));
    }
}
