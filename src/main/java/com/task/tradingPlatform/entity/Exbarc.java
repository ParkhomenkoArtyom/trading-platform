package com.task.tradingPlatform.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Exbarc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exbarcId", nullable = false, updatable = false, unique = true)
    private Integer exbarcId;

    @Size(max=30)
    @Column(name = "exbarBody", nullable = false, updatable = false)
    private String exbarBody;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "packId")
    private Pack pack;
}
