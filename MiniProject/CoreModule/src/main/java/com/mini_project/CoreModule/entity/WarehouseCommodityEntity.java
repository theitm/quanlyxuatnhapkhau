package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

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
    @JoinColumn(name = "id_warehouse",insertable = false , updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private WarehouseEntity warehouseEntity;

    @Column( name = "id_warehouse")
    @Type( type = "uuid-char")
    private UUID idWarehouse;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity",insertable = false , updatable = false)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    private CommodityEntity commodityEntity;

    @Column( name = "id_commodity")
    @Type( type = "uuid-char")
    private UUID idCommodity;

    @Column(name = "inventory_number")
    private Double inventoryNumber;

}

