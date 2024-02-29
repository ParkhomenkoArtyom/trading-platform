package com.task.tradingPlatform.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Assortment {
    private String exbarBody; //номер штрихкода;
    private String packName;  //название товара;

    //количество товара (зависит от packType, если packType = 0, то packQuant = 1 (товар штучный),
    //если packType = 1, то packQuant = 1000 (товар весовой измеряется в граммах));
    private Integer PackQuant;
    private Boolean packType;
    private Integer packPrice; //цена товара (в копейках)
    private Integer packBonus; //скидка товара (в копейках)
    private String unitName;   //название единицы измерения;
}
