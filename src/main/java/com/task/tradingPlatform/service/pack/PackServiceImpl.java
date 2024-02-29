package com.task.tradingPlatform.service.pack;

import com.task.tradingPlatform.entity.Pack;
import com.task.tradingPlatform.exception.PackNotFoundException;
import com.task.tradingPlatform.repository.PackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackServiceImpl implements PackService {

    private final PackRepository packRepository;

    @Override
    public List<Pack> getPacksList() {
        return packRepository.getAllPacks().orElseThrow(
                () -> new RuntimeException("Товары отсутствуют"));
    }

    @Override
    public Pack getPackByExbarBody(String exbarBody) {
        return packRepository.findByExbarBody(exbarBody).orElseThrow(
                () -> new PackNotFoundException("Товар со штрихкодом: " + exbarBody + " не найден")
        );
    }

    @Override
    public Boolean isPackQuantityValid(Boolean packType, BigDecimal quantity) {
        if (!packType)
            return quantity.scale() == 0;
        else return true;
    }
}
