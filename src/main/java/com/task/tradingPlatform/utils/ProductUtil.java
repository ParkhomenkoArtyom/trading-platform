package com.task.tradingPlatform.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProductUtil {
    public final static BigDecimal COINS_EXCHANGE_RATE = new BigDecimal(100);
    public final static BigDecimal GRAMS_EXCHANGE_RATE = new BigDecimal(1000);
    public static BigDecimal calculateTotalSum(Integer sum, BigDecimal quantity){
        return BigDecimal.valueOf(sum)
                .divide(new BigDecimal(100), RoundingMode.HALF_UP)
                .multiply(quantity);
    }

    public static Integer toCoins(BigDecimal rubles){
       return rubles.multiply(ProductUtil.COINS_EXCHANGE_RATE).intValue();
    }

    public static Integer toGrams(BigDecimal kgs){
        return kgs.multiply(ProductUtil.GRAMS_EXCHANGE_RATE).intValue();
    }
}
