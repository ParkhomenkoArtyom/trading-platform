package com.task.tradingPlatform.service.product;

import com.task.tradingPlatform.entity.Pack;
import com.task.tradingPlatform.entity.UnitId;
import com.task.tradingPlatform.exception.InvalidPackQuantityException;
import com.task.tradingPlatform.model.Product;
import com.task.tradingPlatform.service.pack.PackService;
import com.task.tradingPlatform.service.unitIdService.UnitIdService;
import com.task.tradingPlatform.utils.ProductUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final UnitIdService unitIdService;
    private final PackService packService;

    @Override
    public Product getProduct(String exbarBody, BigDecimal quantity, Boolean isDiscountProvided) {
        Pack pack = packService.getPackByExbarBody(exbarBody);
        if (!packService.isPackQuantityValid(pack.getPackType(), quantity))
            throw new InvalidPackQuantityException("Штучный товар не может иметь дробное значение");

        return new Product(
                exbarBody,
                pack.getPackName(),
                quantity,
                ProductUtil.calculateTotalSum(pack.getPackPrc().getPackPrice(), quantity),
                isDiscountProvided
                        ? ProductUtil.calculateTotalSum(pack.getPackPrc().getPackBonus(), quantity)
                        : BigDecimal.valueOf(0),
                unitIdService.getUnitIdByUnitId(pack.getUnitId()).getUnitName(),
                pack.getPackType()
        );
    }
}
