package com.task.tradingPlatform.service.sales;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
enum SalesTag {
    HEADER_TAG(3),
    CARD_TAG(2),
    CASH_TAG(1),
    PRODUCT_TAG(0);
    private final Integer tag;
}
