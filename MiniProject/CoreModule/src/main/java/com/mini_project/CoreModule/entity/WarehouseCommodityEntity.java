package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_warehouse_commodity")
public class WarehouseCommodityEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_warehouse")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private WarehouseEntity warehouseEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private CommodityEntity commodityEntity;

    @Column(name = "inventory_number")
    private Double inventoryNumber;

}

