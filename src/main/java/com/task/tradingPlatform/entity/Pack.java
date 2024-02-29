package com.task.tradingPlatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Pack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "packId", nullable = false, updatable = false, unique = true)
    private Integer packId;

    @Column(name = "unitId", nullable = false, updatable = false)
    private Integer unitId;

    @Size(max=50)
    @Column(name = "packName", nullable = false, updatable = false)
    private String packName;

    @Column(name = "packQuant", nullable = false, updatable = false)
    private Integer packQuant;

    @Column(name = "packType", nullable = false, updatable = false)
    private Boolean packType;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packId")
    private Exbarc exbarc;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packId")
    private PackPrc packPrc;
}
