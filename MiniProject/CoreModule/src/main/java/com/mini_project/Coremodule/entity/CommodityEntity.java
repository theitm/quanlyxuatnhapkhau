package com.mini_project.Coremodule.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.http.HttpStatus;

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
    @Type(type = "uuid-char")
    private UUID id_sectors;
    private String commodity_name;
    private String description;
    private Float price;
    private String unit;


    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    @JoinColumn(name = "id_commodity")
    Collection<DetailsImportExportEntity> iExportEntities;


    @OneToMany(
            mappedBy = "id_commodity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonManagedReference
    Collection<WarehouseCommodityEntity> warehouseEntity;

    public CommodityEntity(Object save, HttpStatus ok) {
    }
}
