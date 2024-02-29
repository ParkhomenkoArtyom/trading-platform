package com.task.tradingPlatform.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class Sale {
    @Valid
    private List<Product> productList;

    @PositiveOrZero
    private BigDecimal cashPrice;

    @PositiveOrZero
    private BigDecimal cardPrice;
}
