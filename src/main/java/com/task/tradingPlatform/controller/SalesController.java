package com.task.tradingPlatform.controller;

import com.task.tradingPlatform.model.Sale;
import com.task.tradingPlatform.service.sales.SalesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<String> deleteSalesByDate(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") String date) {
        salesService.deleteSalesByDate(date);
        return ResponseEntity.ok("Удаление информации о продаже на заданную дату произошло успешно");

    }
}
