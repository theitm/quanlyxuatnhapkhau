package com.haonguyen.ServiceImport.entity;

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
    @Column(name = "id_commodity", columnDefinition = "CHAR(36)")
    @Type(type = "uuid-char")
    private UUID idCommodity;
    private String idSectors;
    private String commodityName;
    private String description;
    private Float price;
    private String unit;


    @OneToMany(
            mappedBy = "idCommodity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    Collection<DetailsI_exportEntity> iExportEntities;

}
