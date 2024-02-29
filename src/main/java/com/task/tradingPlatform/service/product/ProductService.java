package com.task.tradingPlatform.service.product;

import com.task.tradingPlatform.model.Product;

import java.math.BigDecimal;

public interface ProductService {
    Product getProduct(String exbarBody, BigDecimal quantity, Boolean isDiscountProvided);
}
