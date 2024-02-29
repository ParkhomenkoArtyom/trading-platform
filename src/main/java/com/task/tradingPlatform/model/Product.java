package com.task.tradingPlatform.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product  {
    @Size(max=50) @NotNull
    private String exbarBody;

    @Size(max=50) @NotNull
    private String packName;

    @Positive @NotNull
    private BigDecimal quantity;

    @PositiveOrZero @NotNull
    private BigDecimal totalPrice;

    @PositiveOrZero @NotNull
    private BigDecimal bonusPrice;

    @Size(max=50) @NotNull
    private String unitName;

    @NotNull
    private Boolean packType;
}
