package com.task.tradingPlatform.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PackPrc {
    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "pack_id")
    private Pack pack;

    @Column(name = "packPrice", nullable = false, updatable = false)
    private Integer packPrice;

    @Column(name = "packBonus", nullable = false, updatable = false)
    private Integer packBonus;
}
