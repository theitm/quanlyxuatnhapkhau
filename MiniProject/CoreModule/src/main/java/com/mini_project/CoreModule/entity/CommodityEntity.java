package com.mini_project.CoreModule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "tb_commodity")
public class CommodityEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "commodity_name")
    private String commodityName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Float price;

    @Column(name = "unit")
    private String unit;

    @OneToMany(
            mappedBy = "commodityEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Collection<DetailsImportExportEntity> detailsImportExportEntities;


    @OneToMany(
            mappedBy = "commodityEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    private Collection<WarehouseCommodityEntity> warehouseCommodityEntities;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_of_commodity")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonBackReference
    private TypeOfCommodityEntity typeOfCommodityEntity;

}
