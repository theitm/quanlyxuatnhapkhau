package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tb_warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "description")
    private String description;

    @Column(name = "capacity")
    private Double capacity;

    @OneToMany(
            mappedBy = "warehouseEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Collection<WarehouseCommodityEntity> warehouseCommodityEntities;



}
