package com.task.tradingPlatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class UnitId {
    @Id
    @JoinColumn(name = "unit_id")
    private Integer unitId;

    @Size(max=50)
    @Column(name = "unitName", nullable = false, updatable = false)
    private String unitName;
}
