package com.task.tradingPlatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@Data
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesId", nullable = false, updatable = false, unique = true)
    private Integer salesId;

    @CreationTimestamp
    @Column(name = "salesTime", updatable = false)
    private Timestamp salesTime;

    @Column(name = "salesTag", updatable = false)
    private Integer salesTag;

    @Size(max=30)
    @Column(name = "exbarBody", updatable = false)
    private String exbarBody;

    @Size(max=50)
    @Column(name = "packName", updatable = false)
    private String packName;

    @Size(max=50)
    @Column(name = "unitName", updatable = false)
    private String unitName;

    @Column(name = "price", nullable = false, updatable = false)
    private Integer price;

    @Column(name = "bonusPrice", updatable = false)
    private Integer bonusPrice;

    @Column(name = "quantity", updatable = false)
    private Integer quantity;

    public Sales(Integer salesTag, String exbarBody, String packName, String unitName, Integer price, Integer bonusPrice, Integer quantity) {
        this.salesTag = salesTag;
        this.exbarBody = exbarBody;
        this.packName = packName;
        this.unitName = unitName;
        this.price = price;
        this.bonusPrice = bonusPrice;
        this.quantity = quantity;
    }
}
