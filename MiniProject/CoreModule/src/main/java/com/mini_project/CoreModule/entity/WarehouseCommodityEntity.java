package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_warehouse_commodity")
public class WarehouseCommodityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_warehouse")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    WarehouseEntity id_warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_commodity")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonBackReference
    CommodityEntity id_commodity;

    private Double inventoryNumber;

}

