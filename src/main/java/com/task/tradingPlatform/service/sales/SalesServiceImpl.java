package com.task.tradingPlatform.service.sales;

import com.task.tradingPlatform.entity.Sales;
import com.task.tradingPlatform.exception.InvalidDateFormatException;
import com.task.tradingPlatform.exception.NotEnoughMoneyException;
import com.task.tradingPlatform.exception.SalesNotFoundException;
import com.task.tradingPlatform.model.Product;
import com.task.tradingPlatform.model.Sale;
import com.task.tradingPlatform.repository.SalesRepository;
import com.task.tradingPlatform.utils.DateUtil;
import com.task.tradingPlatform.utils.ProductUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    public BigDecimal processSale(Sale saleRequestDto) {
        List<Product> products = saleRequestDto.getProductList();

        BigDecimal totalPrice = getTotalPrice(products);
        BigDecimal totalBonus = getTotalBonus(products);

        BigDecimal cashChange = calculateCashChange(
                totalPrice,
                totalBonus,
                saleRequestDto.getCashPrice(),
                saleRequestDto.getCardPrice()
        );

        if (cashChange.compareTo(BigDecimal.ZERO) < 0)
            throw new NotEnoughMoneyException("Не достаточно денег для оплаты");

        saveProcessedSales(
                products,
                ProductUtil.toCoins(totalPrice),
                ProductUtil.toCoins(totalBonus),
                ProductUtil.toCoins(saleRequestDto.getCardPrice()),
                ProductUtil.toCoins(saleRequestDto.getCashPrice()
                ));
        return cashChange;
    }

    @Override
    public void deleteSalesByDate(String date) {
        if (!GenericValidator.isDate(date, "yyyy-MM-dd HH:mm:ss", true))
            throw new InvalidDateFormatException("Не верный формат даты. Шаблон: yyyy-MM-dd HH:mm:ss");
        Calendar dateFromString = DateUtil.getDateFromString(date);
        if (salesRepository.deleteSalesByDateWithSecondInterval(dateFromString,
                DateUtil.getDateOneSecondMore(dateFromString)) == 0)
            throw new SalesNotFoundException("Записей о продажах на дату " + date + " не обнаружено");
    }


    private void saveProcessedSales(List<Product> products, Integer totalPrice,
                                    Integer totalBonus, Integer cardPrice, Integer cashCard) {
        List<Sales> salesEntitiesToSave = new ArrayList<>();
        products.forEach(
                product -> salesEntitiesToSave.add(new Sales(
                                SalesTag.PRODUCT_TAG.getTag(),
                                product.getExbarBody(),
                                product.getPackName(),
                                product.getUnitName(),
                                ProductUtil.toCoins(product.getTotalPrice()),
                                ProductUtil.toCoins(product.getBonusPrice()),
                                product.getPackType()
                                        ? ProductUtil.toGrams(product.getQuantity())
                                        : product.getQuantity().intValue()
                        )
                ));
        salesEntitiesToSave.add(new Sales(SalesTag.HEADER_TAG.getTag(), null, null, null, totalPrice, totalBonus, null));
        salesEntitiesToSave.add(new Sales(SalesTag.CARD_TAG.getTag(), null, null, null, cardPrice, null, null));
        salesEntitiesToSave.add(new Sales(SalesTag.CASH_TAG.getTag(), null, null, null, cashCard, null, null));
        salesRepository.saveAll(salesEntitiesToSave);
    }

    private BigDecimal calculateCashChange(BigDecimal totalPrice,
                                           BigDecimal totalBonus,
                                           BigDecimal cashPrice,
                                           BigDecimal cardPrice) {
        return cashPrice.add(cardPrice).add(totalBonus).subtract(totalPrice);
    }

    private BigDecimal getTotalPrice(List<Product> products) {
        return products.stream()
                .map(Product::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getTotalBonus(List<Product> products) {
        return products.stream()
                .map(Product::getBonusPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
